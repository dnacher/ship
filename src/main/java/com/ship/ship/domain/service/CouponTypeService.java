package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.CouponTypeDAO;
import com.ship.ship.persistence.model.CouponType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CouponTypeService {

    @Autowired
    private CouponTypeDAO couponTypeDAO;

    public List<CouponType> getCouponType(){
        return couponTypeDAO.getCouponType();
    }

    public CouponType getCouponTypeById(Integer id){
        return couponTypeDAO.getCouponTypeById(id);
    }

    public CouponType saveCouponType(CouponType couponType){
        return couponTypeDAO.saveCouponType(couponType);
    }

    public CouponType updateCouponType(CouponType couponType){
        return couponTypeDAO.updateCouponType(couponType);
    }

    public void deleteCouponType(CouponType couponType){
        couponTypeDAO.deleteCouponType(couponType);
    }
}
