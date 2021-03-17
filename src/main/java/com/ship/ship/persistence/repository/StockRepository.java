package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.model.Product;
import com.ship.ship.persistence.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository  extends CrudRepository<Stock,Integer> {
    List<Stock>findByProduct_FamilyProduct_Id(Integer id);
    List<Stock>findByProduct_FamilyProduct_name(String name);

    Stock findStocksByProductAndBranchOffice(Product product, BranchOffice branchOffice);

    @Query("select s.quantity from Stock s where s.branchOffice= :branchOffice and s.product= :product")
    Integer getQuantityByBranchOfficeAndProduct(BranchOffice branchOffice, Product product);
}
