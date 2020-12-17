package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Coupon;
import com.ship.ship.persistence.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CouponDAO {

    @Autowired
    private CouponRepository repository;

    public List<Coupon> getCoupon(){
        List<Coupon> coupons = new ArrayList<>();
        this.repository.findAll().forEach(coupon -> coupons.add(coupon));
        return coupons;
    }

    public Coupon getCouponById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The coupon id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public Coupon saveCoupon(Coupon coupon) throws ShipException {
        return this.repository.save(coupon);
    }

    public List<Coupon> saveCoupons(List<Coupon> coupons) throws ShipException {
        List<Coupon> finalList= new ArrayList<>();
        this.repository.saveAll(coupons).forEach(coupon -> {
            finalList.add(coupon);
        });
        return finalList;
    }

    public void deleteCoupon(Coupon coupon){
        this.repository.delete(coupon);
    }

    public Coupon updateCoupon(Coupon coupon) throws ShipException {
        if(coupon.getId()!=null){
            return this.repository.save(coupon);
        }else{
            String msg = String.format("Cannot update a coupon without an Id");
            throw new ShipException(msg);
        }
    }
}
