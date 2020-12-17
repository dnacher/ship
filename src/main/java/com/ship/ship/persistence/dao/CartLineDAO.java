package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.CartLine;
import com.ship.ship.persistence.repository.CartLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartLineDAO {

    @Autowired
    private CartLineRepository repository;

    public List<CartLine> getOrderLine(){
        List<CartLine> cartLines = new ArrayList<>();
        this.repository.findAll().forEach(cartLine -> cartLines.add(cartLine));
        return cartLines;
    }

    public CartLine getOrderLineById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The orderLine id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public CartLine saveOrderLine(CartLine cartLine) throws ShipException {
        return this.repository.save(cartLine);
    }

    public List<CartLine> saveOrderLines(List<CartLine> cartLines) throws ShipException {
        List<CartLine> finalList= new ArrayList<>();
        this.repository.saveAll(cartLines).forEach(cartLine -> {
            finalList.add(cartLine);
        });
        return finalList;
    }

    public void deleteOrderLine(CartLine cartLine){
        this.repository.delete(cartLine);
    }

    public CartLine updateOrderLine(CartLine cartLine) throws ShipException {
        if(cartLine.getId()!=null){
            return this.repository.save(cartLine);
        }else{
            String msg = String.format("Cannot update a orderLine without an Id");
            throw new ShipException(msg);
        }
    }
}
