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
package com.CooperWMartin.WeatherForecastApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.CooperWMartin.WeatherForecastApp.dtos.WeatherForecast.*;
import com.CooperWMartin.WeatherForecastApp.exceptions.ResourceNotFoundException;
import com.CooperWMartin.WeatherForecastApp.services.IWeatherForecastService;

@RestController
@RequestMapping("/api/weather-forecast")
public class WeatherForecastController {

  @Autowired
  private IWeatherForecastService weatherForecastService;

  @GetMapping("/")
  public String index() {
    return "Greetings from the Weather Forecast API.";
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<WeatherForecastResponse>> getWeatherForecastById(@PathVariable Long id) {
    List<WeatherForecastResponse> weatherForecastList = weatherForecastService.getWeatherForecastResponsesById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Weather Forecast not found for id: " + id));
    return ResponseEntity.ok(weatherForecastList);
  }
}