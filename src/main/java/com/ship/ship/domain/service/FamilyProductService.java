package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.FamilyProductDAO;
import com.ship.ship.persistence.model.FamilyProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FamilyProductService {

    @Autowired
    private FamilyProductDAO familyProductDAO;

    public List<FamilyProduct> getFamilyProduct(){
        return familyProductDAO.getFamilyProduct();
    }

    public FamilyProduct getFamilyProductById(Integer id){
        return familyProductDAO.getFamilyProductById(id);
    }

    public FamilyProduct saveFamilyProduct(FamilyProduct familyProduct){
        return familyProductDAO.saveFamilyProduct(familyProduct);
    }

    public FamilyProduct updateFamilyProduct(FamilyProduct familyProduct){
        return familyProductDAO.updateFamilyProduct(familyProduct);
    }

    public void deleteFamilyProduct(FamilyProduct familyProduct){
        familyProductDAO.deleteFamilyProduct(familyProduct);
    }
}
