package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.CouponType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponTypeRepository  extends CrudRepository<CouponType,Integer> {
}
