package com.ship.ship.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer quantity;

    @Column
    private Integer quantityWarning;

    @Column
    private Boolean active;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_office_id")
    private BranchOffice branchOffice;


    public Stock(){}

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getQuantityWarning() {
        return quantityWarning;
    }

    public Boolean getActive() {
        return active;
    }

    public BranchOffice getBranchOffice() {
        return branchOffice;
    }
}
