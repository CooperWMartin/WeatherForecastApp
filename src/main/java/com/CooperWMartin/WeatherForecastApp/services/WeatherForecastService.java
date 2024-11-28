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

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.CooperWMartin.WeatherForecastApp.dtos.WeatherForecast.Period;
import com.CooperWMartin.WeatherForecastApp.dtos.WeatherForecast.WeatherForecast;
import com.CooperWMartin.WeatherForecastApp.dtos.WeatherForecast.WeatherForecastResponse;
import com.CooperWMartin.WeatherForecastApp.clients.WeatherForecastApiClient;
import com.CooperWMartin.WeatherForecastApp.models.GridLocation;
import com.CooperWMartin.WeatherForecastApp.models.StreetAddress;
import com.CooperWMartin.WeatherForecastApp.utils.WeatherForecastConverter;
import com.CooperWMartin.WeatherForecastApp.utils.WeatherForecastParser;
import com.CooperWMartin.WeatherForecastApp.utils.WeatherForecastUtils;

@Service
public class WeatherForecastService implements IWeatherForecastService {

  @Autowired
  private IStreetAddressService streetAddressService;

  @Autowired
  private WeatherForecastApiClient weatherForecastApiClient;

  @Autowired
  private WeatherForecastParser weatherForecastParser;

  @Override
  public Optional<List<WeatherForecastResponse>> getWeatherForecastResponsesById(Long id) {
    // get the street address by id
    Optional<StreetAddress> streetAddress = streetAddressService.getStreetAddressById(id);

    if (!streetAddress.isPresent()) {
      return Optional.empty();
    }

    // get the grid location from the street address
    GridLocation gridLocation = streetAddress.get().getGridLocation();

    // get the weather forecast from the grid location
    Optional<WeatherForecast> weatherForecast = getWeatherForecast(gridLocation);

    if (!weatherForecast.isPresent()) {
      return Optional.empty();
    }

    // convert the WeatherForecast object to a List of WeatherForecastResponse object
    List<WeatherForecastResponse> weatherForecastResponses = new ArrayList<>();
    List<Period> periods = WeatherForecastUtils.getPeriods(weatherForecast.get());
    for (Period period : periods) {
      WeatherForecastResponse weatherForecastResponse = new WeatherForecastResponse();
      weatherForecastResponse = WeatherForecastConverter.weatherForecastPeriod2WeatherForecastResponse(period);
      weatherForecastResponses.add(weatherForecastResponse);
    }

    // return the WeatherForecastResponse object
    return Optional.of(weatherForecastResponses);
  }

  public Optional<WeatherForecast> getWeatherForecast(GridLocation gridLocation) {
    Optional<String> forecast = weatherForecastApiClient.getWeatherForecast(gridLocation);

    if (forecast.isPresent()) {
      return Optional.of(weatherForecastParser.toWeatherForecastObject(forecast.get()));
    } else {
      return Optional.empty();
    }
  }
}
