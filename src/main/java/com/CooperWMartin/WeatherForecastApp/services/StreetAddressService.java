/**
 * MIT License
 *
 * Copyright (c) 2024 Scott Davis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.CooperWMartin.WeatherForecastApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CooperWMartin.WeatherForecastApp.models.GridLocation;
import com.CooperWMartin.WeatherForecastApp.models.StreetAddress;
import com.CooperWMartin.WeatherForecastApp.repositories.StreetAddressRepository;
import com.CooperWMartin.WeatherForecastApp.clients.GridPointApiClient;
import com.CooperWMartin.WeatherForecastApp.clients.LocationApiClient;
import com.CooperWMartin.WeatherForecastApp.dtos.StreetAddressCreateRequest;
import com.CooperWMartin.WeatherForecastApp.dtos.StreetAddressResponse;
import com.CooperWMartin.WeatherForecastApp.dtos.GridPoint.GridPoint;
import com.CooperWMartin.WeatherForecastApp.dtos.Location.Location;
import com.CooperWMartin.WeatherForecastApp.utils.GridPointParser;
import com.CooperWMartin.WeatherForecastApp.utils.LocationParser;
import com.CooperWMartin.WeatherForecastApp.utils.StreetAddressConverter;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class StreetAddressService implements IStreetAddressService {
  
  @Autowired
  private StreetAddressRepository streetAddressRepository;
  
  private static final Logger LOGGER = Logger.getLogger(StreetAddressService.class.getName());

  @Override
  public StreetAddressResponse saveStreetAddress(StreetAddressCreateRequest streetAddressCreateRequest) {
    // Convert a StreetAddressCreateRequest object to a StreetAddress object
    StreetAddress streetAddress = StreetAddressConverter
        .streetAddressCreateRequest2StreetAddress(streetAddressCreateRequest);

    // Get the GridPoint object for the street address
    Optional<GridPoint> gridPoint = getGridPointFromStreetAddress(streetAddress);
    if (gridPoint.isEmpty()) {
      LOGGER.log(Level.WARNING, "Failed to get grid point");
      return null;
    }

    // Convert the GridPoint object to GridLocation object
    GridLocation gridLocation = new GridPointParser().getGridLocation(gridPoint.get());

    // Store the GridPoint object in the Street Address object
    streetAddress.setGridLocation(gridLocation);
    StreetAddress savedStreetAddress = streetAddressRepository.save(streetAddress);

    return StreetAddressConverter.streetAddress2StreetAddressResponse(savedStreetAddress);
  }

  // Get a grid point for a street address
  Optional<GridPoint> getGridPointFromStreetAddress(StreetAddress streetAddress) {
    // Convert the street address to a location
    LocationApiClient locationApiClient = new LocationApiClient();
    Optional<String> locationString = locationApiClient.getLocation(streetAddress);
    if (locationString.isEmpty()) {
      return Optional.empty();
    }
    LocationParser locationParser = new LocationParser();
    Location location = locationParser.ToLocationObject(locationString.get());
    if (location == null) {
      return Optional.empty();
    }

    // Convert the location to a grid point
    GridPointApiClient gridPointApiClient = new GridPointApiClient();
    Optional<String> gridPointString = gridPointApiClient.getGridPoint(location, 0);
    if (gridPointString.isEmpty()) {
      return Optional.empty();
    }
    GridPointParser gridPointParser = new GridPointParser();
    GridPoint gridPoint = gridPointParser.ToGridPointObject(gridPointString.get());
    if (gridPoint == null) {
      return Optional.empty();
    }

    return Optional.of(gridPoint);
  }

  @Override
  public Optional<StreetAddress> getStreetAddressById(Long id) {
    return streetAddressRepository.findById(id);
  }

  @Override
  public Optional<StreetAddressResponse> getStreetAddressResponseById(Long id) {
    Optional<StreetAddress> streetAddress = streetAddressRepository.findById(id);

    if (streetAddress.isPresent()) {
      return Optional.ofNullable(StreetAddressConverter.streetAddress2StreetAddressResponse(streetAddress.get()));
    }
    return Optional.empty();
  }

  @Override
  public List<StreetAddressResponse> getStreetAddresses() {
    List<StreetAddress> streetAddresses = streetAddressRepository.findAll();

    List<StreetAddressResponse> streetAddressResponseDtos = new ArrayList<>();
    for (StreetAddress streetAddress : streetAddresses) {
      StreetAddressResponse streetAddressResponseDto = StreetAddressConverter
          .streetAddress2StreetAddressResponse(streetAddress);
      streetAddressResponseDtos.add(streetAddressResponseDto);
    }
    return streetAddressResponseDtos;
  }

  @Override
  public void deleteStreetAddress(Long id) {
    streetAddressRepository.deleteById(id);
  }

  @Override
  public long countStreetAddresses() {
    return streetAddressRepository.count();
  }

  @Override
  public boolean streetAddressExists(StreetAddressCreateRequest streetAddressCreateRequest) {
    StreetAddress streetAddress = StreetAddressConverter
        .streetAddressCreateRequest2StreetAddress(streetAddressCreateRequest);
    StreetAddress duplicateStreetAddress = streetAddressRepository.findByNumberAndStreetAndCityAndStateAndZipCode(
        streetAddress.getNumber(),
        streetAddress.getStreet(), streetAddress.getCity(), streetAddress.getState(), streetAddress.getZipCode());

    return duplicateStreetAddress != null;
  }
}
