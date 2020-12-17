package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends CrudRepository<Address,Integer> {
}
