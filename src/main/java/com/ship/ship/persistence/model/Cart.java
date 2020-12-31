package com.ship.ship.persistence.model;

import java.util.List;

public class Cart {

    private CartHeader cartHeader;
    private List<CartLine> cartLines;

    public Cart(){}

    public CartHeader getCartHeader() {
        return cartHeader;
    }

    public void setCartHeader(CartHeader cartHeader) {
        this.cartHeader = cartHeader;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }
}
