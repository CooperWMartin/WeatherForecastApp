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
 
package com.CooperWMartin.WeatherForecastApp.dtos.GridPoint;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {

  @JsonProperty("@id")
  private String id;

  @JsonProperty("@type")
  private String type;

  private String cwa;
  private String forecastOffice;
  private String gridId;
  private int gridX;
  private int gridY;
  private String forecast;
  private String forecastHourly;
  private String forecastGridData;
  private String observationStations;
  private RelativeLocation relativeLocation;
  private String forecastZone;
  private String county;
  private String fireWeatherZone;
  private String timeZone;
  private String radarStation;

  // Default constructor
  public Properties() {
  }

  // Getters and setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCwa() {
    return cwa;
  }

  public void setCwa(String cwa) {
    this.cwa = cwa;
  }

  public String getForecastOffice() {
    return forecastOffice;
  }

  public void setForecastOffice(String forecastOffice) {
    this.forecastOffice = forecastOffice;
  }

  public String getGridId() {
    return gridId;
  }

  public void setGridId(String gridId) {
    this.gridId = gridId;
  }

  public int getGridX() {
    return gridX;
  }

  public void setGridX(int gridX) {
    this.gridX = gridX;
  }

  public int getGridY() {
    return gridY;
  }

  public void setGridY(int gridY) {
    this.gridY = gridY;
  }

  public String getForecast() {
    return forecast;
  }

  public void setForecast(String forecast) {
    this.forecast = forecast;
  }

  public String getForecastHourly() {
    return forecastHourly;
  }

  public void setForecastHourly(String forecastHourly) {
    this.forecastHourly = forecastHourly;
  }

  public String getForecastGridData() {
    return forecastGridData;
  }

  public void setForecastGridData(String forecastGridData) {
    this.forecastGridData = forecastGridData;
  }

  public String getObservationStations() {
    return observationStations;
  }

  public void setObservationStations(String observationStations) {
    this.observationStations = observationStations;
  }

  public RelativeLocation getRelativeLocation() {
    return relativeLocation;
  }

  public void setRelativeLocation(RelativeLocation relativeLocation) {
    this.relativeLocation = relativeLocation;
  }

  public String getForecastZone() {
    return forecastZone;
  }

  public void setForecastZone(String forecastZone) {
    this.forecastZone = forecastZone;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getFireWeatherZone() {
    return fireWeatherZone;
  }

  public void setFireWeatherZone(String fireWeatherZone) {
    this.fireWeatherZone = fireWeatherZone;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public String getRadarStation() {
    return radarStation;
  }

  public void setRadarStation(String radarStation) {
    this.radarStation = radarStation;
  }
}
