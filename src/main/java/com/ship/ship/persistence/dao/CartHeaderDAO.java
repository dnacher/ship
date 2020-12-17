package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.CartHeader;
import com.ship.ship.persistence.repository.CartHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartHeaderDAO {

    @Autowired
    private CartHeaderRepository repository;

    public List<CartHeader> getOrderHeader(){
        List<CartHeader> cartHeaders = new ArrayList<>();
        this.repository.findAll().forEach(orderHeader -> cartHeaders.add(orderHeader));
        return cartHeaders;
    }

    public CartHeader getOrderHeaderById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The orderHeader id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public CartHeader saveOrderHeader(CartHeader cartHeader) throws ShipException {
        return this.repository.save(cartHeader);
    }

    public List<CartHeader> saveOrderHeaders(List<CartHeader> cartHeaders) throws ShipException {
        List<CartHeader> finalList= new ArrayList<>();
        this.repository.saveAll(cartHeaders).forEach(orderHeader -> {
            finalList.add(orderHeader);
        });
        return finalList;
    }

    public void deleteOrderHeader(CartHeader cartHeader){
        this.repository.delete(cartHeader);
    }

    public CartHeader updateOrderHeader(CartHeader cartHeader) throws ShipException {
        if(cartHeader.getId()!=null){
            return this.repository.save(cartHeader);
        }else{
            String msg = String.format("Cannot update a orderHeader without an Id");
            throw new ShipException(msg);
        }
    }
}
