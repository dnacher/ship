package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.CouponType;
import com.ship.ship.persistence.repository.CouponTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CouponTypeDAO {

  private final Logger log = LoggerFactory.getLogger(CouponTypeDAO.class.getName());
  @Autowired private CouponTypeRepository repository;

  public List<CouponType> getCouponType() {
    log.info("getCouponType");
    List<CouponType> couponTypes = new ArrayList<>();
    this.repository.findAll().forEach(couponType -> couponTypes.add(couponType));
    return couponTypes;
  }

  public CouponType getCouponTypeById(Integer id) throws ShipException {
    log.info("getCouponTypeById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The couponType id %s does not exist", id);
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public CouponType saveCouponType(CouponType couponType) throws ShipException {
    log.info("saveCouponType ", couponType);
    return this.repository.save(couponType);
  }

  public List<CouponType> saveCouponTypes(List<CouponType> couponTypees) throws ShipException {
    List<CouponType> finalList = new ArrayList<>();
    this.repository
        .saveAll(couponTypees)
        .forEach(
            couponType -> {
              finalList.add(couponType);
            });
    return finalList;
  }

  public void deleteCouponType(CouponType couponType) {
    log.info("deleteCouponType ", couponType);
    this.repository.delete(couponType);
  }

  public CouponType updateCouponType(CouponType couponType) throws ShipException {
    if (couponType.getId() != null) {
      log.info("updateCouponType ", couponType);
      return this.repository.save(couponType);
    } else {
      String msg = String.format("Cannot update a couponType without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
