package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Neighborhood;
import com.ship.ship.persistence.repository.NeighborghoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NeighborhoodDAO {

  private final Logger log = LoggerFactory.getLogger(NeighborhoodDAO.class.getName());
  @Autowired private NeighborghoodRepository repository;

  public List<Neighborhood> getNeighborhood() {
    log.info("getNeighborhood");
    List<Neighborhood> neighborhoods = new ArrayList<>();
    this.repository.findAll().forEach(neighborhood -> neighborhoods.add(neighborhood));
    return neighborhoods;
  }

  public Neighborhood getNeighborhoodById(Integer id) throws ShipException {
    log.info("getNeighborhoodById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The neighborhood id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public Neighborhood saveNeighborhood(Neighborhood neighborhood) throws ShipException {
    log.info("saveNeighborhood ", neighborhood);
    return this.repository.save(neighborhood);
  }

  public List<Neighborhood> saveNeighborhoods(List<Neighborhood> neighborhoods)
      throws ShipException {
    List<Neighborhood> finalList = new ArrayList<>();
    this.repository
        .saveAll(neighborhoods)
        .forEach(
            neighborhood -> {
              finalList.add(neighborhood);
            });
    return finalList;
  }

  public void deleteNeighborhood(Neighborhood neighborhood) {
    log.info("deleteNeighborhood ", neighborhood);
    this.repository.delete(neighborhood);
  }

  public Neighborhood updateNeighborhood(Neighborhood neighborhood) throws ShipException {
    if (neighborhood.getId() != null) {
      log.info("updateNeighborhood ", neighborhood);
      return this.repository.save(neighborhood);
    } else {
      String msg = String.format("Cannot update a neighborhood without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
