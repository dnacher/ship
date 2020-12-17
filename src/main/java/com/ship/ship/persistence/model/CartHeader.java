package com.ship.ship.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cart_header")
public class CartHeader {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_office_id")
    private BranchOffice branchOffice;

    @Column
    private Date date;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private Status status;

    @Column
    private Double total;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @Column
    private String observation;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_type_id")
    private DeliveryType deliveryType;

    @Column
    private Boolean scheduledOrder;

    @Column
    private Date timeSchedule;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    private User delivery;

    public CartHeader(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BranchOffice getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(BranchOffice branchOffice) {
        this.branchOffice = branchOffice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Boolean getScheduledOrder() {
        return scheduledOrder;
    }

    public void setScheduledOrder(Boolean scheduledOrder) {
        this.scheduledOrder = scheduledOrder;
    }

    public Date getTimeSchedule() {
        return timeSchedule;
    }

    public void setTimeSchedule(Date timeSchedule) {
        this.timeSchedule = timeSchedule;
    }

    public User getDelivery() {
        return delivery;
    }

    public void setDelivery(User delivery) {
        this.delivery = delivery;
    }
}
