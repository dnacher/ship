package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.CouponTypeService;
import com.ship.ship.persistence.model.CouponType;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/coupon_types")
public class CouponTypeController {

    private final CouponTypeService couponTypeService;

    public CouponTypeController(CouponTypeService couponTypeService){
        this.couponTypeService = couponTypeService;
    }

    @PostMapping(value = "/")
    public CouponType saveCouponType(@RequestBody CouponType couponType){
        return this.couponTypeService.saveCouponType(couponType);
    }

    @PostMapping(value = "/mul")
    public List<CouponType> saveCouponTypees(@RequestBody List<CouponType> couponTypees){
        List<CouponType> finalList = new ArrayList<>();
        couponTypees.forEach(couponType -> {
            finalList.add(this.couponTypeService.saveCouponType(couponType));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public CouponType updateCouponType(@PathVariable Integer id, @RequestBody CouponType couponType){
        String msg = String.format("The CouponType Id %s is different from the Url Id",couponType.getId());
        Utils.validateUrlIdEqualsBodyId(id,couponType.getId(),msg);
        return this.couponTypeService.updateCouponType(couponType);
    }

    @PutMapping(value = "/mul")
    public List<CouponType> updateCouponType(@RequestBody List<CouponType> couponTypees){
        List<CouponType> finalList = new ArrayList<>();
        couponTypees.forEach(couponType -> {
            finalList.add(this.couponTypeService.updateCouponType(couponType));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<CouponType> getCouponType(){
        return this.couponTypeService.getCouponType();
    }

    @GetMapping(value = "/{id}")
    public CouponType getCouponTypeById(@PathVariable Integer id){
        return this.couponTypeService.getCouponTypeById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCouponType(@PathVariable Integer id, CouponType couponType){
        String msg = String.format("The CouponType Id %s is different from the Url Id",couponType.getId());
        Utils.validateUrlIdEqualsBodyId(id,couponType.getId(),msg);
        this.couponTypeService.deleteCouponType(couponType);
    }
}
