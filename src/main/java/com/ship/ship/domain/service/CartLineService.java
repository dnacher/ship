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
        return cartLineDAO.getCartLine();
    }

    public CartLine getOrderLineById(Integer id){
        return cartLineDAO.getCartLineById(id);
    }

    public CartLine saveOrderLine(CartLine cartLine){
        return cartLineDAO.saveCartLine(cartLine);
    }

    public CartLine updateOrderLine(CartLine cartLine){
        return cartLineDAO.updateCartLine(cartLine);
    }

    public void deleteOrderLine(CartLine cartLine){
        cartLineDAO.deleteCartLine(cartLine);
    }
}

