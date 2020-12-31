package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.CartLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartLineRepository extends CrudRepository<CartLine,Integer> {
    List<CartLine> findByCartHeader_Id(Integer id);
}
