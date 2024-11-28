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

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForecastResponse {
  private int number;
  private String name;
  private String startTime;
  private String endTime;
  @JsonProperty("isDaytime")
  private boolean daytime;
  private int temperature;
  private String temperatureUnit;
  private String temperatureTrend;
  private ProbabilityOfPrecipitation probabilityOfPrecipitation;
  private String windSpeed;
  private String windDirection;
  private String icon;
  private String shortForecast;
  private String detailedForecast;

  // Default constructor
  public WeatherForecastResponse() {
  }

  // Getters and setters
  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public boolean isDaytime() {
    return daytime;
  }

  public void setDaytime(boolean isDaytime) {
    this.daytime = isDaytime;
  }

  public int getTemperature() {
    return temperature;
  }

  public void setTemperature(int temperature) {
    this.temperature = temperature;
  }

  public String getTemperatureUnit() {
    return temperatureUnit;
  }

  public void setTemperatureUnit(String temperatureUnit) {
    this.temperatureUnit = temperatureUnit;
  }

  public String getTemperatureTrend() {
    return temperatureTrend;
  }

  public void setTemperatureTrend(String temperatureTrend) {
    this.temperatureTrend = temperatureTrend;
  }

  public ProbabilityOfPrecipitation getProbabilityOfPrecipitation() {
    return probabilityOfPrecipitation;
  }

  public void setProbabilityOfPrecipitation(ProbabilityOfPrecipitation probabilityOfPrecipitation) {
    this.probabilityOfPrecipitation = probabilityOfPrecipitation;
  }

  public String getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(String windSpeed) {
    this.windSpeed = windSpeed;
  }

  public String getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(String windDirection) {
    this.windDirection = windDirection;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getShortForecast() {
    return shortForecast;
  }

  public void setShortForecast(String shortForecast) {
    this.shortForecast = shortForecast;
  }

  public String getDetailedForecast() {
    return detailedForecast;
  }

  public void setDetailedForecast(String detailedForecast) {
    this.detailedForecast = detailedForecast;
  }
}
