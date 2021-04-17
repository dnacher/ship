package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.CartHeader;
import com.ship.ship.persistence.repository.CartHeaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartHeaderDAO {

  private final Logger log = LoggerFactory.getLogger(CartHeaderDAO.class.getName());
  @Autowired private CartHeaderRepository repository;

  public List<CartHeader> getOrderHeader() {
    List<CartHeader> cartHeaders = new ArrayList<>();
    this.repository.findAll().forEach(orderHeader -> cartHeaders.add(orderHeader));
    log.info("getOrderHeader");
    return cartHeaders;
  }

  public CartHeader getOrderHeaderById(Integer id) throws ShipException {
    log.info("getOrderHeaderById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The orderHeader id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public CartHeader saveOrderHeader(CartHeader cartHeader) throws ShipException {
    log.info("saveOrderHeader ", cartHeader);
    return this.repository.save(cartHeader);
  }

  public List<CartHeader> saveOrderHeaders(List<CartHeader> cartHeaders) throws ShipException {
    List<CartHeader> finalList = new ArrayList<>();
    this.repository
        .saveAll(cartHeaders)
        .forEach(
            orderHeader -> {
              finalList.add(orderHeader);
            });
    return finalList;
  }

  public void deleteOrderHeader(CartHeader cartHeader) {
    log.info("deleteOrderHeader ", cartHeader);
    this.repository.delete(cartHeader);
  }

  public CartHeader updateOrderHeader(CartHeader cartHeader) throws ShipException {
    if (cartHeader.getId() != null) {
      log.info("updateOrderHeader ", cartHeader);
      return this.repository.save(cartHeader);
    } else {
      String msg = String.format("Cannot update a orderHeader without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
