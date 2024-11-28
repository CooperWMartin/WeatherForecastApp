package com.CooperWMartin.WeatherForecastApp.dtos;

public class LastUsedStreetAddressResponse {
  private Long lastUsedStreetAddressId;

  public LastUsedStreetAddressResponse() {
  }

  public LastUsedStreetAddressResponse(Long lastUsedStreetAddressId) {
    this.lastUsedStreetAddressId = lastUsedStreetAddressId;
  }

  public Long getLastUsedStreetAddressId() {
    return lastUsedStreetAddressId;
  }

  public void setLastUsedStreetAddressId(Long lastUsedStreetAddressId) {
    this.lastUsedStreetAddressId = lastUsedStreetAddressId;
  }
}
