package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.repository.FamilyProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FamilyProductDAO {

  private final Logger log = LoggerFactory.getLogger(FamilyProductDAO.class.getName());
  @Autowired private FamilyProductRepository repository;

  public List<FamilyProduct> getFamilyProduct() {
    log.info("getFamilyProduct");
    List<FamilyProduct> familyProducts = new ArrayList<>();
    this.repository.findAll().forEach(familyProduct -> familyProducts.add(familyProduct));
    return familyProducts;
  }

  public FamilyProduct getFamilyProductById(Integer id) throws ShipException {
    log.info("getFamilyProductById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The familyProduct id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public FamilyProduct saveFamilyProduct(FamilyProduct familyProduct) throws ShipException {
    log.info("saveFamilyProduct ", familyProduct);
    return this.repository.save(familyProduct);
  }

  public List<FamilyProduct> saveFamilyProducts(List<FamilyProduct> familyProducts)
      throws ShipException {
    List<FamilyProduct> finalList = new ArrayList<>();
    this.repository
        .saveAll(familyProducts)
        .forEach(
            familyProduct -> {
              finalList.add(familyProduct);
            });
    return finalList;
  }

  public void deleteFamilyProduct(FamilyProduct familyProduct) {
    log.info("deleteFamilyProduct ", familyProduct);
    this.repository.delete(familyProduct);
  }

  public FamilyProduct updateFamilyProduct(FamilyProduct familyProduct) throws ShipException {
    if (familyProduct.getId() != null) {
      log.info("updateFamilyProduct ", familyProduct);
      return this.repository.save(familyProduct);
    } else {
      String msg = String.format("Cannot update a familyProduct without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
