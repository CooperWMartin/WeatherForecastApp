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

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period {
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
  public Period() {
  }

  // Parameterized constructor
  public Period(int number, String name, String startTime, String endTime, boolean isDaytime, int temperature,
      String temperatureUnit, String temperatureTrend, ProbabilityOfPrecipitation probabilityOfPrecipitation,
      String windSpeed, String windDirection, String icon, String shortForecast, String detailedForecast) {
    this.number = number;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
    this.daytime = isDaytime;
    this.temperature = temperature;
    this.temperatureUnit = temperatureUnit;
    this.temperatureTrend = temperatureTrend;
    this.probabilityOfPrecipitation = probabilityOfPrecipitation;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.icon = icon;
    this.shortForecast = shortForecast;
    this.detailedForecast = detailedForecast;
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

  @Override
  public String toString() {
    // Define the desired format for date-time output
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss z");

    // Parse the start and end time strings into ZonedDateTime
    ZonedDateTime start = ZonedDateTime.parse(startTime);
    ZonedDateTime end = ZonedDateTime.parse(endTime);

    // Format the date-time strings using the defined formatter
    String formattedStartTime = start.format(formatter);
    String formattedEndTime = end.format(formatter);

    StringBuilder sb = new StringBuilder();
    sb.append("Forecast for ").append(name).append(":\n");
    sb.append("Start Time: ").append(formattedStartTime).append("\n");
    sb.append("End Time: ").append(formattedEndTime).append("\n");
    sb.append("Daytime: ").append(daytime ? "Yes" : "No").append("\n");
    sb.append("Temperature: ").append(temperature).append(" ").append(temperatureUnit).append("\n");
    if (temperatureTrend != null && !temperatureTrend.isEmpty()) {
      sb.append("Temperature Trend: ").append(temperatureTrend).append("\n");
    }
    sb.append("Wind: ").append(windSpeed).append(" from ").append(windDirection).append("\n");
    sb.append("Short Forecast: ").append(shortForecast).append("\n");
    sb.append("Detailed Forecast: ").append(detailedForecast).append("\n");

    if (probabilityOfPrecipitation != null && probabilityOfPrecipitation.getValue() != null) {
      sb.append("Precipitation Probability: ").append(probabilityOfPrecipitation.getValue()).append("%").append("\n");
    } else {
      sb.append("Precipitation Probability: N/A\n");
    }

    sb.append("Icon: ").append(icon).append("\n");

    return sb.toString();
  }
}
