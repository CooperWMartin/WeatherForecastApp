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

import com.CooperWMartin.WeatherForecastApp.models.StreetAddress;

import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;

public class LocationApiClient {
  private static final String BASE_URL = "https://geocoding.geo.census.gov/geocoder/locations/";
  private static final Logger LOGGER = Logger.getLogger(LocationApiClient.class.getName());

  public Optional<String> getLocation(StreetAddress streetAddress) {

    String oneLineAddress = "onelineaddress?address=" + streetAddress.formatAddress() + "&benchmark=4&format=json";

    String apiUri = BASE_URL + oneLineAddress;

    HttpClient client = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10)) // Set a timeout for connection
        .followRedirects(HttpClient.Redirect.NORMAL) // Follow 301/302 redirects automatically
        .build();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(apiUri))
        .timeout(Duration.ofSeconds(10)) // Set a timeout for the request
        .GET()
        .build();

    try {
      // Send the request and receive the response
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        return Optional.of(response.body());
      } else {
        LOGGER.log(Level.WARNING, "Failed to get location. HTTP status code: {0}", response.statusCode());
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

  public Optional<String> getLocation(String address) {

    // Encode the address to be HTTP compatible
    try {
      address = URLEncoder.encode(address, StandardCharsets.UTF_8.toString());
    } catch (Exception e) {
      Logger.getLogger(LocationApiClient.class.getName()).log(Level.SEVERE, "Failed to encode address. Exception: {0}",
          e.getMessage());
      return Optional.empty();
    }

    String apiUri = BASE_URL +
        "onelineaddress?address=" + address +
        "&benchmark=4&format=json";

    HttpClient client = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10)) // Set a timeout for connection
        .followRedirects(HttpClient.Redirect.NORMAL) // Follow 301/302 redirects automatically
        .build();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(apiUri))
        .timeout(Duration.ofSeconds(10)) // Set a timeout for the request
        .GET()
        .build();

    try {
      // Send the request and receive the response
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        return Optional.of(response.body());
      } else {
        LOGGER.log(Level.WARNING, "Failed to get location. HTTP status code: {0}", response.statusCode());
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
