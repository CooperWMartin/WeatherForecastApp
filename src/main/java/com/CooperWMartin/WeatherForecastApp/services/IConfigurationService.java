package com.CooperWMartin.WeatherForecastApp.services;

import java.util.Optional;

public interface IConfigurationService {
  void saveLastUsedStreetAddressId(Long value);
  Optional<Long> getLastUsedStreetAddressId();
}
