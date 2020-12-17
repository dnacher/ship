package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.CouponService;
import com.ship.ship.persistence.model.Coupon;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService){
        this.couponService = couponService;
    }

    @PostMapping(value = "/")
    public Coupon saveCoupon(@RequestBody Coupon coupon){
        return this.couponService.saveCoupon(coupon);
    }

    @PostMapping(value = "/mul")
    public List<Coupon> saveCoupones(@RequestBody List<Coupon> coupones){
        List<Coupon> finalList = new ArrayList<>();
        coupones.forEach(coupon -> {
            finalList.add(this.couponService.saveCoupon(coupon));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public Coupon updateCoupon(@PathVariable Integer id, @RequestBody Coupon coupon){
        String msg = String.format("The Coupon Id %s is different from the Url Id",coupon.getId());
        Utils.validateUrlIdEqualsBodyId(id,coupon.getId(),msg);
        return this.couponService.updateCoupon(coupon);
    }

    @PutMapping(value = "/mul")
    public List<Coupon> updateCoupon(@RequestBody List<Coupon> coupones){
        List<Coupon> finalList = new ArrayList<>();
        coupones.forEach(coupon -> {
            finalList.add(this.couponService.updateCoupon(coupon));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<Coupon> getCoupon(){
        return this.couponService.getCoupon();
    }

    @GetMapping(value = "/{id}")
    public Coupon getCouponById(@PathVariable Integer id){
        return this.couponService.getCouponById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCoupon(@PathVariable Integer id, Coupon coupon){
        String msg = String.format("The Coupon Id %s is different from the Url Id",coupon.getId());
        Utils.validateUrlIdEqualsBodyId(id,coupon.getId(),msg);
        this.couponService.deleteCoupon(coupon);
    }
}
