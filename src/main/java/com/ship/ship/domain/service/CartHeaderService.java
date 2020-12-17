package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.CartHeaderDAO;
import com.ship.ship.persistence.model.CartHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartHeaderService {

    @Autowired
    private CartHeaderDAO cartHeaderDAO;

    public List<CartHeader> getOrderHeader(){
        return cartHeaderDAO.getOrderHeader();
    }

    public CartHeader getOrderHeaderById(Integer id){
        return cartHeaderDAO.getOrderHeaderById(id);
    }

    public CartHeader saveOrderHeader(CartHeader cartHeader){
        return cartHeaderDAO.saveOrderHeader(cartHeader);
    }

    public CartHeader updateOrderHeader(CartHeader cartHeader){
        return cartHeaderDAO.updateOrderHeader(cartHeader);
    }

    public void deleteOrderHeader(CartHeader cartHeader){
        cartHeaderDAO.deleteOrderHeader(cartHeader);
    }
}
