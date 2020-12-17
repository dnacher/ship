package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.CouponType;
import com.ship.ship.persistence.repository.CouponTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CouponTypeDAO {

    @Autowired
    private CouponTypeRepository repository;

    public List<CouponType> getCouponType(){
        List<CouponType> couponTypes = new ArrayList<>();
        this.repository.findAll().forEach(couponType -> couponTypes.add(couponType));
        return couponTypes;
    }

    public CouponType getCouponTypeById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The couponType id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public CouponType saveCouponType(CouponType couponType) throws ShipException {
        return this.repository.save(couponType);
    }

    public List<CouponType> saveCouponTypes(List<CouponType> couponTypees) throws ShipException {
        List<CouponType> finalList= new ArrayList<>();
        this.repository.saveAll(couponTypees).forEach(couponType -> {
            finalList.add(couponType);
        });
        return finalList;
    }

    public void deleteCouponType(CouponType couponType){
        this.repository.delete(couponType);
    }

    public CouponType updateCouponType(CouponType couponType) throws ShipException {
        if(couponType.getId()!=null){
            return this.repository.save(couponType);
        }else{
            String msg = String.format("Cannot update a couponType without an Id");
            throw new ShipException(msg);
        }
    }
}
