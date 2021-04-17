package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.NeighborhoodService;
import com.ship.ship.persistence.model.Neighborhood;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/neighborhoods")
public class NeighborhoodController {

  private final NeighborhoodService neighborhoodService;

  public NeighborhoodController(NeighborhoodService neighborhoodService) {
    this.neighborhoodService = neighborhoodService;
  }

  @PostMapping(value = "/")
  public Neighborhood saveNeighborhood(@RequestBody Neighborhood neighborhood) {
    return this.neighborhoodService.saveNeighborhood(neighborhood);
  }

  @PostMapping(value = "/mul")
  public List<Neighborhood> saveNeighborhoodes(@RequestBody List<Neighborhood> neighborhoods) {
    List<Neighborhood> finalList = new ArrayList<>();
    neighborhoods.forEach(
        neighborhood -> {
          finalList.add(this.neighborhoodService.saveNeighborhood(neighborhood));
        });
    return finalList;
  }

  @PutMapping(value = "/{id}")
  public Neighborhood updateNeighborhood(
      @PathVariable Integer id, @RequestBody Neighborhood neighborhood) {
    String msg =
        String.format("The Neighborhood Id %s is different from the Url Id", neighborhood.getId());
    Utils.validateUrlIdEqualsBodyId(id, neighborhood.getId(), msg);
    return this.neighborhoodService.updateNeighborhood(neighborhood);
  }

  @PutMapping(value = "/mul")
  public List<Neighborhood> updateNeighborhood(@RequestBody List<Neighborhood> neighborhoods) {
    List<Neighborhood> finalList = new ArrayList<>();
    neighborhoods.forEach(
        neighborhood -> {
          finalList.add(this.neighborhoodService.updateNeighborhood(neighborhood));
        });
    return finalList;
  }

  @GetMapping(value = "/")
  public List<Neighborhood> getNeighborhood() {
    return this.neighborhoodService.getNeighborhood();
  }

  @GetMapping(value = "/{id}")
  public Neighborhood getNeighborhoodById(@PathVariable Integer id) {
    return this.neighborhoodService.getNeighborhoodById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteNeighborhood(@PathVariable Integer id, Neighborhood neighborhood) {
    String msg =
        String.format("The Neighborhood Id %s is different from the Url Id", neighborhood.getId());
    Utils.validateUrlIdEqualsBodyId(id, neighborhood.getId(), msg);
    this.neighborhoodService.deleteNeighborhood(neighborhood);
  }
}
