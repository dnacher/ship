package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.model.Product;
import com.ship.ship.persistence.model.Stock;
import com.ship.ship.persistence.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockDAO {

  private final Logger log = LoggerFactory.getLogger(StockDAO.class.getName());
  @Autowired private StockRepository repository;

  public List<Stock> getStock() {
    log.info("getStock");
    List<Stock> stocks = new ArrayList<>();
    this.repository.findAll().forEach(stock -> stocks.add(stock));
    return stocks;
  }

  public Stock getStockById(Integer id) throws ShipException {
    log.info("getStockById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The stock id %s does not exist", id);
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public Integer getQuantityByBranchOfficeAndProduct(BranchOffice branchOffice, Product product) {
    log.info("getQuantityByBranchOfficeAndProduct ", branchOffice, product);
    return this.repository.getQuantityByBranchOfficeAndProduct(branchOffice, product);
  }

  public List<Stock> getStockByFamilyProduct(Integer id) throws ShipException {
    log.info("getStockByFamilyProduct {0}", id);
    List<Stock> stocks = new ArrayList<>();
    this.repository.findByProduct_FamilyProduct_Id(id).forEach(stock -> stocks.add(stock));
    return stocks;
  }

  public List<Stock> getStockByFamilyProductName(String name) throws ShipException {
    log.info("getStockByFamilyProductName ", name);
    List<Stock> stocks = new ArrayList<>();
    this.repository.findByProduct_FamilyProduct_name(name).forEach(stock -> stocks.add(stock));
    return stocks;
  }

  public Stock saveStock(Stock stock) throws ShipException {
    log.info("saveStock ", stock);
    return this.repository.save(stock);
  }

  public List<Stock> saveStocks(List<Stock> stocks) throws ShipException {
    List<Stock> finalList = new ArrayList<>();
    this.repository
        .saveAll(stocks)
        .forEach(
            stock -> {
              finalList.add(stock);
            });
    return finalList;
  }

  public void deleteStock(Stock stock) {
    log.info("deleteStock ", stock);
    this.repository.delete(stock);
  }

  public Stock updateStock(Stock stock) throws ShipException {
    if (stock.getId() != null) {
      log.info("updateStock ", stock);
      return this.repository.save(stock);
    } else {
      String msg = String.format("Cannot update a stock without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
