package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Status;
import com.ship.ship.persistence.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatusDAO {

  private final Logger log = LoggerFactory.getLogger(StatusDAO.class.getName());
  @Autowired private StatusRepository repository;

  public List<Status> getStatus() {
    log.info("getStatus");
    List<Status> statusList = new ArrayList<>();
    this.repository.findAll().forEach(status -> statusList.add(status));
    return statusList;
  }

  public Status getStatusById(Integer id) throws ShipException {
    log.info("getStatusById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The status id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public Status saveStatus(Status status) throws ShipException {
    log.info("saveStatus ", status);
    return this.repository.save(status);
  }

  public List<Status> saveStatuses(List<Status> statusList) throws ShipException {
    List<Status> finalList = new ArrayList<>();
    this.repository
        .saveAll(statusList)
        .forEach(
            status -> {
              finalList.add(status);
            });
    return finalList;
  }

  public void deleteStatus(Status status) {
    log.info("deleteStatus ", status);
    this.repository.delete(status);
  }

  public Status updateStatus(Status status) throws ShipException {
    if (status.getId() != null) {
      log.info("updateStatus ", status);
      return this.repository.save(status);
    } else {
      String msg = String.format("Cannot update a status without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
