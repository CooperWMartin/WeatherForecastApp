package com.CooperWMartin.WeatherForecastApp.repositories;

import com.CooperWMartin.WeatherForecastApp.models.LastUsedStreetAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<LastUsedStreetAddress, String> {
}
