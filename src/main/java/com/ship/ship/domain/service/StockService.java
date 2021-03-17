package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.StockDAO;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.model.Product;
import com.ship.ship.persistence.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockService {

    @Autowired
    private StockDAO stockDAO;

    public List<Stock> getStock(){
        return stockDAO.getStock();
    }

    public Stock getStockById(Integer id){
        return stockDAO.getStockById(id);
    }

    public Integer getQuantityByBranchOfficeAndProduct(BranchOffice branchOffice, Product product) { return stockDAO.getQuantityByBranchOfficeAndProduct(branchOffice,product);}

    public Stock saveStock(Stock stock){
        return stockDAO.saveStock(stock);
    }

    public Stock updateStock(Stock stock){
        return stockDAO.updateStock(stock);
    }

    public void deleteStock(Stock stock){
        stockDAO.deleteStock(stock);
    }

    public List<Stock> getStockByFamilyProduct (Integer id){
        return stockDAO.getStockByFamilyProduct(id);
    }

    public List<Stock> getStockByFamilyProductName (String name){
        return stockDAO.getStockByFamilyProductName(name);
    }
}
