package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.DeliveryType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryTypeRepository  extends CrudRepository<DeliveryType,Integer> {
}
