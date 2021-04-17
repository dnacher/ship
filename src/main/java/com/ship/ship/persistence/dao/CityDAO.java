package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.City;
import com.ship.ship.persistence.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityDAO {

  private final Logger log = LoggerFactory.getLogger(CityDAO.class.getName());
  @Autowired private CityRepository repository;

  public List<City> getCity() {
    log.info("getCity");
    List<City> cities = new ArrayList<>();
    this.repository.findAll().forEach(city -> cities.add(city));
    return cities;
  }

  public City getCityById(Integer id) throws ShipException {
    log.info("getCityById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The city id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public City saveCity(City city) throws ShipException {
    log.info("saveCity ", city);
    return this.repository.save(city);
  }

  public List<City> saveCities(List<City> cities) throws ShipException {
    List<City> finalList = new ArrayList<>();
    this.repository
        .saveAll(cities)
        .forEach(
            city -> {
              finalList.add(city);
            });
    return finalList;
  }

  public void deleteCity(City city) {
    this.repository.delete(city);
  }

  public City updateCity(City city) throws ShipException {
    if (city.getId() != null) {
      return this.repository.save(city);
    } else {
      String msg = String.format("Cannot update a city without an Id");
      throw new ShipException(msg);
    }
  }
}
