package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.repository.FamilyProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FamilyProductDAO {

    @Autowired
    private FamilyProductRepository repository;

    public List<FamilyProduct> getFamilyProduct(){
        List<FamilyProduct> familyProducts = new ArrayList<>();
        this.repository.findAll().forEach(familyProduct -> familyProducts.add(familyProduct));
        return familyProducts;
    }

    public FamilyProduct getFamilyProductById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The familyProduct id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public FamilyProduct saveFamilyProduct(FamilyProduct familyProduct) throws ShipException {
        return this.repository.save(familyProduct);
    }

    public List<FamilyProduct> saveFamilyProducts(List<FamilyProduct> familyProducts) throws ShipException {
        List<FamilyProduct> finalList= new ArrayList<>();
        this.repository.saveAll(familyProducts).forEach(familyProduct -> {
            finalList.add(familyProduct);
        });
        return finalList;
    }

    public void deleteFamilyProduct(FamilyProduct familyProduct){
        this.repository.delete(familyProduct);
    }

    public FamilyProduct updateFamilyProduct(FamilyProduct familyProduct) throws ShipException {
        if(familyProduct.getId()!=null){
            return this.repository.save(familyProduct);
        }else{
            String msg = String.format("Cannot update a familyProduct without an Id");
            throw new ShipException(msg);
        }
    }
}
