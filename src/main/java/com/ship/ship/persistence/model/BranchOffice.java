package com.ship.ship.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "branch_office")
public class BranchOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column
    private Double score;

    @Column
    private Integer openingHour;

    @Column
    private Integer openingMinutes;

    @Column
    private Integer closeHour;

    @Column
    private Integer closeMinutes;

    @Column
    private Boolean isOpen;

    public BranchOffice(){}

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(Integer openingHour) {
        this.openingHour = openingHour;
    }

    public Integer getOpeningMinutes() {
        return openingMinutes;
    }

    public void setOpeningMinutes(Integer openingMinutes) {
        this.openingMinutes = openingMinutes;
    }

    public Integer getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Integer closeHour) {
        this.closeHour = closeHour;
    }

    public Integer getCloseMinutes() {
        return closeMinutes;
    }

    public void setCloseMinutes(Integer closeMinutes) {
        this.closeMinutes = closeMinutes;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }
}
