package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.CartHeaderService;
import com.ship.ship.persistence.model.CartHeader;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/order_headers")
public class CartHeaderController {

  private final CartHeaderService cartHeaderService;

  public CartHeaderController(CartHeaderService cartHeaderService) {
    this.cartHeaderService = cartHeaderService;
  }

  @PostMapping(value = "/")
  public CartHeader saveOrderHeader(@RequestBody CartHeader cartHeader) {
    return this.cartHeaderService.saveOrderHeader(cartHeader);
  }

  @PostMapping(value = "/mul")
  public List<CartHeader> saveOrderHeaderes(@RequestBody List<CartHeader> cartHeaderes) {
    List<CartHeader> finalList = new ArrayList<>();
    cartHeaderes.forEach(
        orderHeader -> {
          finalList.add(this.cartHeaderService.saveOrderHeader(orderHeader));
        });
    return finalList;
  }

  @PutMapping(value = "/{id}")
  public CartHeader updateOrderHeader(
      @PathVariable Integer id, @RequestBody CartHeader cartHeader) {
    String msg =
        String.format("The OrderHeader Id %s is different from the Url Id", cartHeader.getId());
    Utils.validateUrlIdEqualsBodyId(id, cartHeader.getId(), msg);
    return this.cartHeaderService.updateOrderHeader(cartHeader);
  }

  @PutMapping(value = "/mul")
  public List<CartHeader> updateOrderHeader(@RequestBody List<CartHeader> cartHeaderes) {
    List<CartHeader> finalList = new ArrayList<>();
    cartHeaderes.forEach(
        orderHeader -> {
          finalList.add(this.cartHeaderService.updateOrderHeader(orderHeader));
        });
    return finalList;
  }

  @GetMapping(value = "/")
  public List<CartHeader> getOrderHeader() {
    return this.cartHeaderService.getOrderHeader();
  }

  @GetMapping(value = "/{id}")
  public CartHeader getOrderHeaderById(@PathVariable Integer id) {
    return this.cartHeaderService.getOrderHeaderById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteOrderHeader(@PathVariable Integer id, CartHeader cartHeader) {
    String msg =
        String.format("The OrderHeader Id %s is different from the Url Id", cartHeader.getId());
    Utils.validateUrlIdEqualsBodyId(id, cartHeader.getId(), msg);
    this.cartHeaderService.deleteOrderHeader(cartHeader);
  }
}
