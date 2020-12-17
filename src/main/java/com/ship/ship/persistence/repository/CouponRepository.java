package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository  extends CrudRepository<Coupon,Integer> {
}
