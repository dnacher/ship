package com.ship.ship.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "family_product")
public class FamilyProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer quantityWarning;

    @Column
    private Boolean active=true;

    public FamilyProduct(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityWarning() {
        return quantityWarning;
    }

    public void setQuantityWarning(Integer quantityWarning) {
        this.quantityWarning = quantityWarning;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
