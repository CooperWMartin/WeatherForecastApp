package com.CooperWMartin.WeatherForecastApp.models;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class LastUsedStreetAddress {
  public static final String KEY = "LastUsedStreetAddressId";

  @Id
  @Column(name = "id_key")
  private String idKey;


  private Long lastUsedStreetAddressId;

  public LastUsedStreetAddress() {
    this.idKey = KEY;
  }

  public LastUsedStreetAddress(Long lastUsedStreetAddressId) {
    this.idKey = KEY;
    this.lastUsedStreetAddressId = lastUsedStreetAddressId;
  }

  public String getIdKey() {
    return idKey;
  }

  public Long getLastUsedStreetAddressId() {
    return lastUsedStreetAddressId;
  }

  public void setLastUsedStreetAddressId(Long lastUsedStreetAddressId) {
    this.lastUsedStreetAddressId = lastUsedStreetAddressId;
  }

}
