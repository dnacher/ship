package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository  extends CrudRepository<City,Integer> {
}
