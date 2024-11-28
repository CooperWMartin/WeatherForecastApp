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
 
package com.CooperWMartin.WeatherForecastApp.dtos.WeatherForecast;

import java.util.List;

public class Properties {
  private String units;
  private String forecastGenerator;
  private String generatedAt;
  private String updateTime;
  private String validTimes;
  private Elevation elevation;
  private List<Period> periods;

  // Default constructor
  public Properties() {
  }

  // Parameterized constructor
  public Properties(String units, String forecastGenerator, String generatedAt, String updateTime,
      String validTimes, Elevation elevation, List<Period> periods) {
    this.units = units;
    this.forecastGenerator = forecastGenerator;
    this.generatedAt = generatedAt;
    this.updateTime = updateTime;
    this.validTimes = validTimes;
    this.elevation = elevation;
    this.periods = periods;
  }

  // Getters and setters
  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }

  public String getForecastGenerator() {
    return forecastGenerator;
  }

  public void setForecastGenerator(String forecastGenerator) {
    this.forecastGenerator = forecastGenerator;
  }

  public String getGeneratedAt() {
    return generatedAt;
  }

  public void setGeneratedAt(String generatedAt) {
    this.generatedAt = generatedAt;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public String getValidTimes() {
    return validTimes;
  }

  public void setValidTimes(String validTimes) {
    this.validTimes = validTimes;
  }

  public Elevation getElevation() {
    return elevation;
  }

  public void setElevation(Elevation elevation) {
    this.elevation = elevation;
  }

  public List<Period> getPeriods() {
    return periods;
  }

  public void setPeriods(List<Period> periods) {
    this.periods = periods;
  }
}