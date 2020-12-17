package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.CartLineService;
import com.ship.ship.persistence.model.CartLine;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/order_lines")
public class CartLineController {

    private final CartLineService cartLineService;

    public CartLineController(CartLineService cartLineService){
        this.cartLineService = cartLineService;
    }

    @PostMapping(value = "/")
    public CartLine saveOrderLine(@RequestBody CartLine cartLine){
        return this.cartLineService.saveOrderLine(cartLine);
    }

    @PostMapping(value = "/mul")
    public List<CartLine> saveOrderLinees(@RequestBody List<CartLine> cartLines){
        List<CartLine> finalList = new ArrayList<>();
        cartLines.forEach(cartLine -> {
            finalList.add(this.cartLineService.saveOrderLine(cartLine));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public CartLine updateOrderLine(@PathVariable Integer id, @RequestBody CartLine cartLine){
        String msg = String.format("The OrderLine Id %s is different from the Url Id", cartLine.getId());
        Utils.validateUrlIdEqualsBodyId(id, cartLine.getId(),msg);
        return this.cartLineService.updateOrderLine(cartLine);
    }

    @PutMapping(value = "/mul")
    public List<CartLine> updateOrderLine(@RequestBody List<CartLine> cartLines){
        List<CartLine> finalList = new ArrayList<>();
        cartLines.forEach(cartLine -> {
            finalList.add(this.cartLineService.updateOrderLine(cartLine));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<CartLine> getOrderLine(){
        return this.cartLineService.getOrderLine();
    }

    @GetMapping(value = "/{id}")
    public CartLine getOrderLineById(@PathVariable Integer id){
        return this.cartLineService.getOrderLineById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrderLine(@PathVariable Integer id, CartLine cartLine){
        String msg = String.format("The OrderLine Id %s is different from the Url Id", cartLine.getId());
        Utils.validateUrlIdEqualsBodyId(id, cartLine.getId(),msg);
        this.cartLineService.deleteOrderLine(cartLine);
    }
}
