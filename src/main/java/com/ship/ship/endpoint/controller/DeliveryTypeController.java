package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.DeliveryTypeService;
import com.ship.ship.persistence.model.DeliveryType;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/delivery_types")
public class DeliveryTypeController {

  private final DeliveryTypeService deliveryTypeService;

  public DeliveryTypeController(DeliveryTypeService deliveryTypeService) {
    this.deliveryTypeService = deliveryTypeService;
  }

  @PostMapping(value = "/")
  public DeliveryType saveDeliveryType(@RequestBody DeliveryType deliveryType) {
    return this.deliveryTypeService.saveDeliveryType(deliveryType);
  }

  @PostMapping(value = "/mul")
  public List<DeliveryType> saveDeliveryTypees(@RequestBody List<DeliveryType> deliveryTypees) {
    List<DeliveryType> finalList = new ArrayList<>();
    deliveryTypees.forEach(
        deliveryType -> {
          finalList.add(this.deliveryTypeService.saveDeliveryType(deliveryType));
        });
    return finalList;
  }

  @PutMapping(value = "/{id}")
  public DeliveryType updateDeliveryType(
      @PathVariable Integer id, @RequestBody DeliveryType deliveryType) {
    String msg =
        String.format("The DeliveryType Id %s is different from the Url Id", deliveryType.getId());
    Utils.validateUrlIdEqualsBodyId(id, deliveryType.getId(), msg);
    return this.deliveryTypeService.updateDeliveryType(deliveryType);
  }

  @PutMapping(value = "/mul")
  public List<DeliveryType> updateDeliveryType(@RequestBody List<DeliveryType> deliveryTypees) {
    List<DeliveryType> finalList = new ArrayList<>();
    deliveryTypees.forEach(
        deliveryType -> {
          finalList.add(this.deliveryTypeService.updateDeliveryType(deliveryType));
        });
    return finalList;
  }

  @GetMapping(value = "/")
  public List<DeliveryType> getDeliveryType() {
    return this.deliveryTypeService.getDeliveryType();
  }

  @GetMapping(value = "/{id}")
  public DeliveryType getDeliveryTypeById(@PathVariable Integer id) {
    return this.deliveryTypeService.getDeliveryTypeById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteDeliveryType(@PathVariable Integer id, DeliveryType deliveryType) {
    String msg =
        String.format("The DeliveryType Id %s is different from the Url Id", deliveryType.getId());
    Utils.validateUrlIdEqualsBodyId(id, deliveryType.getId(), msg);
    this.deliveryTypeService.deleteDeliveryType(deliveryType);
  }
}
