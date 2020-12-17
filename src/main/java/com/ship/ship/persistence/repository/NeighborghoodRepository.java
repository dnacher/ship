package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.Neighborhood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeighborghoodRepository  extends CrudRepository<Neighborhood,Integer> {
}
