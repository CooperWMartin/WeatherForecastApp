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

package com.CooperWMartin.WeatherForecastApp.clients;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.io.IOException;
import java.time.Duration;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.CooperWMartin.WeatherForecastApp.models.GridLocation;

@Component
public class WeatherForecastApiClient {
  private static final Logger LOGGER = Logger.getLogger(WeatherForecastApiClient.class.getName());
  private static final String BASE_URL = "https://api.weather.gov/gridpoints/";

  // https://api.weather.gov/gridpoints/STO/53,76/forecast
  public Optional<String> getWeatherForecast(GridLocation gridLocation) {
    String apiUri = String.format("%s%s/%d,%d/forecast", BASE_URL,
        gridLocation.getGridId(),
        gridLocation.getGridX(),
        gridLocation.getGridY());

    HttpClient client = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10)) // Set a timeout for connection
        .followRedirects(HttpClient.Redirect.NORMAL) // Follow 301/302 redirects automatically
        .build();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(apiUri.toString()))
        .timeout(Duration.ofSeconds(10)) // Set a timeout for the request
        .GET()
        .build();

    try {
      // Send the request and receive the response
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        return Optional.of(response.body());
      } else {
        LOGGER.log(Level.WARNING, "Failed to get weather forecast. HTTP status code: {0}", response.statusCode());
        return Optional.empty();
      }
    } catch (HttpTimeoutException e) {
      LOGGER.log(Level.SEVERE, "Request timed out: {0}", e.getMessage());
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "I/O error during the request: {0}", e.getMessage());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt(); // Restore interrupt status
      LOGGER.log(Level.SEVERE, "Request was interrupted: {0}", e.getMessage());
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
    }

    return Optional.empty();
  }
}