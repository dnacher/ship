package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository  extends CrudRepository<Country,Integer> {
}
