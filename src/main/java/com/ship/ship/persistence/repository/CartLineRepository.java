package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.CartLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartLineRepository extends CrudRepository<CartLine,Integer> {
}
