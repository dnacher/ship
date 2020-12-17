package com.ship.ship.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_line")
public class CartLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "order_header_id")
    private CartHeader cartHeader;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer quantity;

    @Column
    private Double subTotal;

    public CartLine(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CartHeader getOrderHeader() {
        return cartHeader;
    }

    public void setOrderHeader(CartHeader cartHeader) {
        this.cartHeader = cartHeader;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
