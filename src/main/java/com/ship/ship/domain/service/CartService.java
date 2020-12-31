package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.CartDAO;
import com.ship.ship.persistence.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CartService {

    @Autowired
    private CartDAO cartDAO;

    public Cart getCartByHeaderId(Integer id){
        return cartDAO.getCartByHeaderId(id);
    }

    public Cart saveCart(Cart cart){
        return cartDAO.saveCart(cart);
    }

    public void deleteCart(Cart cart){
        cartDAO.deleteCart(cart);
    }

}
