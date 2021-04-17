package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.CartService;
import com.ship.ship.persistence.model.Cart;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public/carts")
public class CartController {

  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @PostMapping(value = "/")
  public Cart saveCart(@RequestBody Cart cart) {
    return this.cartService.saveCart(cart);
  }

  @GetMapping(value = "/{id}")
  public Cart getCartByHeaderId(@PathVariable Integer id) {
    return this.cartService.getCartByHeaderId(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteCart(@PathVariable Integer id, Cart cart) {
    String msg =
        String.format("The cart Id %s is different from the Url Id", cart.getCartHeader().getId());
    Utils.validateUrlIdEqualsBodyId(id, cart.getCartHeader().getId(), msg);
    this.cartService.deleteCart(cart);
  }
}
