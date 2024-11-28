package com.CooperWMartin.WeatherForecastApp.services;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.CooperWMartin.WeatherForecastApp.models.LastUsedStreetAddress;
import com.CooperWMartin.WeatherForecastApp.repositories.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService implements IConfigurationService {

  @Autowired
  private ConfigurationRepository configurationRepository;

  private static final Logger LOGGER = Logger.getLogger(ConfigurationService.class.getName());

  @Override
  public void saveLastUsedStreetAddressId(Long id) {

    Optional<LastUsedStreetAddress> optionalLastUsedStreetAddress = configurationRepository
        .findById(LastUsedStreetAddress.KEY);

    LastUsedStreetAddress lastUsedStreetAddress;
    if (optionalLastUsedStreetAddress.isPresent()) {
      lastUsedStreetAddress = optionalLastUsedStreetAddress.get();
      lastUsedStreetAddress.setLastUsedStreetAddressId(id);
    } else {
      lastUsedStreetAddress = new LastUsedStreetAddress();
      lastUsedStreetAddress.setLastUsedStreetAddressId(id);
    }
    LOGGER.log(Level.INFO, "Saving last used street address id: " + lastUsedStreetAddress.getLastUsedStreetAddressId());
    configurationRepository.save(lastUsedStreetAddress);
  }

  @Override
  public Optional<Long> getLastUsedStreetAddressId() {
    Optional<LastUsedStreetAddress> lastUsedStreetAddress = configurationRepository
        .findById(LastUsedStreetAddress.KEY);
    if (lastUsedStreetAddress.isPresent()) {
      Long id = lastUsedStreetAddress.get().getLastUsedStreetAddressId();
      LOGGER.log(Level.INFO, "Getting last used street address id: " + id);
      return Optional.of(id);
    } else {
      LOGGER.log(Level.WARNING, "Failed to get last used street address id");
      return Optional.empty();
    }
  }
}
