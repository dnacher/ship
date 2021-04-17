package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.model.Product;
import com.ship.ship.persistence.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {

  private final Logger log = LoggerFactory.getLogger(ProductDAO.class.getName());
  @Autowired private ProductRepository repository;

  public List<Product> getProduct() {
    log.info("getProduct");
    List<Product> products = new ArrayList<>();
    this.repository.findAll().forEach(product -> products.add(product));
    return products;
  }

  public Product getProductById(Integer id) throws ShipException {
    log.info("getProductById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The product id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  //    public List<Product> getProductByBranchOffice(BranchOffice branchOffice) throws
  // ShipException {
  //        List<Product> products = this.repository.findByBranchOfficeAndActive(branchOffice,true);
  //        if(products==null){
  //            String msg = String.format("The product branch office %s does not exist",
  // branchOffice.getId().toString());
  //            throw new ShipException(msg);
  //        };
  //        return products;
  //    }

  public List<Product> getProductByFamilyProduct(FamilyProduct familyProduct) throws ShipException {
    List<Product> products = this.repository.findByFamilyProductAndActive(familyProduct, true);
    log.info("getProductByFamilyProduct ", familyProduct);
    if (products == null) {
      String msg =
          String.format(
              "The product family product %s does not exist", familyProduct.getId().toString());
      log.error(msg);
      throw new ShipException(msg);
    }
    ;
    return products;
  }

  public Product saveProduct(Product product) throws ShipException {
    log.info("saveProduct ", product);
    return this.repository.save(product);
  }

  public List<Product> saveProducts(List<Product> products) throws ShipException {
    List<Product> finalList = new ArrayList<>();
    this.repository
        .saveAll(products)
        .forEach(
            product -> {
              finalList.add(product);
            });
    return finalList;
  }

  public void deleteProduct(Product product) {
    log.info("deleteProduct ", product);
    this.repository.delete(product);
  }

  public Product updateProduct(Product product) throws ShipException {
    if (product.getId() != null) {
      log.info("updateProduct ", product);
      return this.repository.save(product);
    } else {
      String msg = String.format("Cannot update a product without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
