package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.UserType;
import com.ship.ship.persistence.repository.UserTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserTypeDAO {

  private final Logger log = LoggerFactory.getLogger(UserTypeDAO.class.getName());
  @Autowired private UserTypeRepository repository;

  public List<UserType> getUserType() {
    log.info("getUserType");
    List<UserType> userTypes = new ArrayList<>();
    this.repository.findAll().forEach(userType -> userTypes.add(userType));
    return userTypes;
  }

  public UserType getUserTypeById(Integer id) throws ShipException {
    log.info("getUserTypeById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The userType id %s does not exist", id);
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public UserType saveUserType(UserType userType) throws ShipException {
    log.info("saveUserType ", userType);
    return this.repository.save(userType);
  }

  public List<UserType> saveUserTypees(List<UserType> userTypes) throws ShipException {
    List<UserType> finalList = new ArrayList<>();
    this.repository
        .saveAll(userTypes)
        .forEach(
            userType -> {
              finalList.add(userType);
            });
    return finalList;
  }

  public void deleteUserType(UserType userType) {
    log.info("deleteUserType ", userType);
    this.repository.delete(userType);
  }

  public UserType updateUserType(UserType userType) throws ShipException {
    if (userType.getId() != null) {
      log.info("updateUserType ", userType);
      return this.repository.save(userType);
    } else {
      String msg = String.format("Cannot update a userType without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
