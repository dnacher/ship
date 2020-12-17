package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.CartHeader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartHeaderRepository extends CrudRepository<CartHeader,Integer> {
}
