package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository  extends CrudRepository<Status,Integer> {
}
