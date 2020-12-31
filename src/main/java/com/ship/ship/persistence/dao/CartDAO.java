package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Cart;
import com.ship.ship.persistence.model.CartHeader;
import com.ship.ship.persistence.model.CartLine;
import com.ship.ship.persistence.repository.CartHeaderRepository;
import com.ship.ship.persistence.repository.CartLineRepository;
import com.ship.ship.persistence.repository.StatusRepository;
import com.ship.ship.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartDAO {

    @Autowired
    private CartLineRepository cartLineRepository;

    @Autowired
    private CartHeaderRepository cartHeaderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    public Cart getCartByHeaderId(Integer id) throws ShipException {
        Cart cart=new Cart();
        cart.setCartHeader(this.cartHeaderRepository.findById(id).get());
        cart.setCartLines(this.cartLineRepository.findByCartHeader_Id(cart.getCartHeader().getId()));
        return cart;
    }

    public Cart saveCart(Cart cart) throws ShipException {
        CartHeader cartHeader = cart.getCartHeader();
        if(cart.getCartHeader().getUser().getId()==null){
            cart.getCartHeader().setUser(this.userRepository.findByEmail("asd"));
            cart.getCartHeader().setDelivery(this.userRepository.findByEmail("asdc"));
        }
        cart.getCartHeader().setStatus(statusRepository.findById(1).get());
        this.cartHeaderRepository.save(cartHeader);
        cart.setCartHeader(cartHeader);
        cart.setCartLines(cart.getCartLines().stream().map(carLine ->{
                carLine.setOrderHeader(cart.getCartHeader());
            return carLine;
        }).collect(Collectors.toList()));
        List<CartLine> finalList= new ArrayList<>();
        this.cartLineRepository.saveAll(cart.getCartLines()).forEach(cartLine -> {
            finalList.add(cartLine);
        });
        cart.setCartLines(finalList);
        return cart;
    }

    public void deleteCart(Cart cart){
        this.cartLineRepository.deleteAll(cart.getCartLines());
        this.cartHeaderRepository.delete(cart.getCartHeader());
    }
}
