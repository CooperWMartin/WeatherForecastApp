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
package com.CooperWMartin.WeatherForecastApp.utils;

import com.CooperWMartin.WeatherForecastApp.dtos.StreetAddressCreateRequest;
import com.CooperWMartin.WeatherForecastApp.dtos.StreetAddressResponse;
import com.CooperWMartin.WeatherForecastApp.models.StreetAddress;

public class StreetAddressConverter {
  public static StreetAddress streetAddressCreateRequest2StreetAddress(StreetAddressCreateRequest streetAddressCreateRequest) {
    StreetAddress streetAddress = new StreetAddress();
    streetAddress.setNumber(streetAddressCreateRequest.getNumber());
    streetAddress.setStreet(streetAddressCreateRequest.getStreet());
    streetAddress.setCity(streetAddressCreateRequest.getCity());
    streetAddress.setState(streetAddressCreateRequest.getState());
    streetAddress.setZipCode(streetAddressCreateRequest.getZipCode());

    return streetAddress;
  }

  public static StreetAddressResponse streetAddress2StreetAddressResponse(StreetAddress streetAddress) {
    StreetAddressResponse streetAddressResponseDto = new StreetAddressResponse();
    streetAddressResponseDto.setId(streetAddress.getId());
    streetAddressResponseDto.setNumber(streetAddress.getNumber());
    streetAddressResponseDto.setStreet(streetAddress.getStreet());
    streetAddressResponseDto.setCity(streetAddress.getCity());
    streetAddressResponseDto.setState(streetAddress.getState());
    streetAddressResponseDto.setZipCode(streetAddress.getZipCode());

    return streetAddressResponseDto;
  }
}
