package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Address;
import com.ship.ship.persistence.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressDAO {

  private final Logger log = LoggerFactory.getLogger(AddressDAO.class.getName());
  @Autowired private AddressRepository repository;

  public List<Address> getAddress() {
    List<Address> addresses = new ArrayList<>();
    this.repository.findAll().forEach(address -> addresses.add(address));
    log.info("getAddress");
    return addresses;
  }

  public Address getAddressById(Integer id) throws ShipException {
    log.info("getAddress {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The address id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public Address saveAddress(Address address) throws ShipException {
    log.info("saveAddress ", address);
    return this.repository.save(address);
  }

  public List<Address> saveAddresses(List<Address> addresses) throws ShipException {
    List<Address> finalList = new ArrayList<>();
    this.repository
        .saveAll(addresses)
        .forEach(
            address -> {
              finalList.add(address);
            });
    return finalList;
  }

  public void deleteAddress(Address address) {
    log.info("deleteAddress ", address);
    this.repository.delete(address);
  }

  public Address updateAddress(Address address) throws ShipException {
    if (address.getId() != null) {
      log.info("updateAddress ", address);
      return this.repository.save(address);
    } else {
      String msg = String.format("Cannot update a address without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
