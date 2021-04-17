package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Coupon;
import com.ship.ship.persistence.repository.CouponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CouponDAO {

  private final Logger log = LoggerFactory.getLogger(CouponDAO.class.getName());
  @Autowired private CouponRepository repository;

  public List<Coupon> getCoupon() {
    log.info("getCoupon");
    List<Coupon> coupons = new ArrayList<>();
    this.repository.findAll().forEach(coupon -> coupons.add(coupon));
    return coupons;
  }

  public Coupon getCouponById(Integer id) throws ShipException {
    log.info("getCouponById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The coupon id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public Coupon saveCoupon(Coupon coupon) throws ShipException {
    log.info("saveCoupon ", coupon);
    return this.repository.save(coupon);
  }

  public List<Coupon> saveCoupons(List<Coupon> coupons) throws ShipException {
    List<Coupon> finalList = new ArrayList<>();
    this.repository
        .saveAll(coupons)
        .forEach(
            coupon -> {
              finalList.add(coupon);
            });
    return finalList;
  }

  public void deleteCoupon(Coupon coupon) {
    log.info("deleteCoupon ", coupon);
    this.repository.delete(coupon);
  }

  public Coupon updateCoupon(Coupon coupon) throws ShipException {
    if (coupon.getId() != null) {
      log.info("updateCoupon ", coupon);
      return this.repository.save(coupon);
    } else {
      String msg = String.format("Cannot update a coupon without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
