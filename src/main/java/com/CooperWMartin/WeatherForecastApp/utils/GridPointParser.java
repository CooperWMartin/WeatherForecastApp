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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.CooperWMartin.WeatherForecastApp.dtos.GridPoint.GridPoint;
import com.CooperWMartin.WeatherForecastApp.models.GridLocation;

public class GridPointParser {
  private ObjectMapper objectMapper;

  public GridPointParser() {
    objectMapper = new ObjectMapper();
  }

  public GridPoint ToGridPointObject(String jsonString) {
    try {
      // Convert JSON string to Java Object
      return objectMapper.readValue(jsonString, GridPoint.class);
    } catch (StreamReadException e) {
      e.getMessage();
      return null;
    } catch (Exception e) {
      e.getMessage();
      return null;
    }
  }

  public String ToJsonString(GridPoint gridPoint) {
    try {
      // Convert Java Object to JSON string
      return objectMapper.writeValueAsString(gridPoint);
    } catch (JsonParseException e) {
      e.getMessage();
      return null;
    } catch (Exception e) {
      e.getMessage();
      return null;
    }
  }

  public GridLocation getGridLocation(GridPoint gridPoint) {
    return new GridLocation(gridPoint.getProperties().getGridId(), gridPoint.getProperties()
        .getGridX(), gridPoint.getProperties().getGridY());
  }
}