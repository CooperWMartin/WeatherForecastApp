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

import com.CooperWMartin.WeatherForecastApp.dtos.WeatherForecast.Period;
import com.CooperWMartin.WeatherForecastApp.dtos.WeatherForecast.WeatherForecastResponse;

public class WeatherForecastConverter {
  public static WeatherForecastResponse weatherForecastPeriod2WeatherForecastResponse(Period weatherForecastPeriod) {
    WeatherForecastResponse response = new WeatherForecastResponse();
    response.setNumber(weatherForecastPeriod.getNumber());
    response.setName(weatherForecastPeriod.getName());
    response.setStartTime(weatherForecastPeriod.getStartTime());
    response.setEndTime(weatherForecastPeriod.getEndTime());
    response.setDaytime(weatherForecastPeriod.isDaytime());
    response.setTemperature(weatherForecastPeriod.getTemperature());
    response.setTemperatureUnit(weatherForecastPeriod.getTemperatureUnit());
    response.setTemperatureTrend(weatherForecastPeriod.getTemperatureTrend());
    response.setProbabilityOfPrecipitation(weatherForecastPeriod.getProbabilityOfPrecipitation());
    response.setWindSpeed(weatherForecastPeriod.getWindSpeed());
    response.setWindDirection(weatherForecastPeriod.getWindDirection());
    response.setIcon(weatherForecastPeriod.getIcon());
    response.setShortForecast(weatherForecastPeriod.getShortForecast());
    response.setDetailedForecast(weatherForecastPeriod.getDetailedForecast());

    return response;
  }
}
