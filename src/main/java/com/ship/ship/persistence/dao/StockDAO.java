package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.model.Product;
import com.ship.ship.persistence.model.Stock;
import com.ship.ship.persistence.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockDAO {

    @Autowired
    private StockRepository repository;

    public List<Stock> getStock(){
        List<Stock> stocks = new ArrayList<>();
        this.repository.findAll().forEach(stock -> stocks.add(stock));
        return stocks;
    }

    public Stock getStockById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The stock id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public Integer getQuantityByBranchOfficeAndProduct(BranchOffice branchOffice, Product product){
        return this.repository.getQuantityByBranchOfficeAndProduct(branchOffice,product);
    }

    public List<Stock> getStockByFamilyProduct(Integer id) throws ShipException {
        List<Stock> stocks = new ArrayList<>();
        this.repository.findByProduct_FamilyProduct_Id(id).forEach(stock -> stocks.add(stock));
        return stocks;
    }

    public List<Stock> getStockByFamilyProductName(String name) throws ShipException {
        List<Stock> stocks = new ArrayList<>();
        this.repository.findByProduct_FamilyProduct_name(name).forEach(stock -> stocks.add(stock));
        return stocks;
    }

    public Stock saveStock(Stock stock) throws ShipException {
        return this.repository.save(stock);
    }

    public List<Stock> saveStocks(List<Stock> stocks) throws ShipException {
        List<Stock> finalList= new ArrayList<>();
        this.repository.saveAll(stocks).forEach(stock -> {
            finalList.add(stock);
        });
        return finalList;
    }

    public void deleteStock(Stock stock){
        this.repository.delete(stock);
    }

    public Stock updateStock(Stock stock) throws ShipException {
        if(stock.getId()!=null){
            return this.repository.save(stock);
        }else{
            String msg = String.format("Cannot update a stock without an Id");
            throw new ShipException(msg);
        }
    }
}
