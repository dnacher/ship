package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.CartLineDAO;
import com.ship.ship.persistence.model.CartLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartLineService {

    @Autowired
    private CartLineDAO cartLineDAO;

    public List<CartLine> getOrderLine(){
        return cartLineDAO.getOrderLine();
    }

    public CartLine getOrderLineById(Integer id){
        return cartLineDAO.getOrderLineById(id);
    }

    public CartLine saveOrderLine(CartLine cartLine){
        return cartLineDAO.saveOrderLine(cartLine);
    }

    public CartLine updateOrderLine(CartLine cartLine){
        return cartLineDAO.updateOrderLine(cartLine);
    }

    public void deleteOrderLine(CartLine cartLine){
        cartLineDAO.deleteOrderLine(cartLine);
    }
}

