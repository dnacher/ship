package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.CouponDAO;
import com.ship.ship.persistence.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CouponService {

    @Autowired
    private CouponDAO couponDAO;

    public List<Coupon> getCoupon(){
        return couponDAO.getCoupon();
    }

    public Coupon getCouponById(Integer id){
        return couponDAO.getCouponById(id);
    }

    public Coupon saveCoupon(Coupon coupon){
        return couponDAO.saveCoupon(coupon);
    }

    public Coupon updateCoupon(Coupon coupon){
        return couponDAO.updateCoupon(coupon);
    }

    public void deleteCoupon(Coupon coupon){
        couponDAO.deleteCoupon(coupon);
    }
}
