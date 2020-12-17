package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends CrudRepository<Product,Integer> {

//    public List<Product> findByBranchOfficeAndActive(BranchOffice branchOffice, Boolean active);
    public List<Product> findByFamilyProductAndActive(FamilyProduct familyProduct, Boolean active);
}
