package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.FamilyProductService;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class FamilyProductController {

    private final FamilyProductService familyProductService;

    public FamilyProductController(FamilyProductService familyProductService){
        this.familyProductService = familyProductService;
    }

    @PostMapping(value = "private/family_products")
    public FamilyProduct saveFamilyProduct(@RequestBody FamilyProduct familyProduct){
        return this.familyProductService.saveFamilyProduct(familyProduct);
    }

    @PostMapping(value = "private/family_products/mul")
    public List<FamilyProduct> saveFamilyProductes(@RequestBody List<FamilyProduct> familyProductes){
        List<FamilyProduct> finalList = new ArrayList<>();
        familyProductes.forEach(familyProduct -> {
            finalList.add(this.familyProductService.saveFamilyProduct(familyProduct));
        });
        return finalList;
    }

    @PutMapping(value = "private/family_products/{id}")
    public FamilyProduct updateFamilyProduct(@PathVariable Integer id, @RequestBody FamilyProduct familyProduct){
        String msg = String.format("The FamilyProduct Id %s is different from the Url Id",familyProduct.getId());
        Utils.validateUrlIdEqualsBodyId(id,familyProduct.getId(),msg);
        return this.familyProductService.updateFamilyProduct(familyProduct);
    }

    @PutMapping(value = "private/family_products/mul")
    public List<FamilyProduct> updateFamilyProduct(@RequestBody List<FamilyProduct> familyProductes){
        List<FamilyProduct> finalList = new ArrayList<>();
        familyProductes.forEach(familyProduct -> {
            finalList.add(this.familyProductService.updateFamilyProduct(familyProduct));
        });
        return finalList;
    }

    @GetMapping(value = "public/family_products/")
    public List<FamilyProduct> getFamilyProduct(){
        return this.familyProductService.getFamilyProduct();
    }

    @GetMapping(value = "public/family_products/{id}")
    public FamilyProduct getFamilyProductById(@PathVariable Integer id){
        return this.familyProductService.getFamilyProductById(id);
    }

    @DeleteMapping(value = "private/family_products/{id}")
    public void deleteFamilyProduct(@PathVariable Integer id, FamilyProduct familyProduct){
        String msg = String.format("The FamilyProduct Id %s is different from the Url Id",familyProduct.getId());
        Utils.validateUrlIdEqualsBodyId(id,familyProduct.getId(),msg);
        this.familyProductService.deleteFamilyProduct(familyProduct);
    }
}
