package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.StockService;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.model.Product;
import com.ship.ship.persistence.model.Stock;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @PostMapping(value = "/private/stocks")
    public Stock saveStock(@RequestBody Stock stock){
        return this.stockService.saveStock(stock);
    }

    @PostMapping(value = "private/stocks/mul")
    public List<Stock> saveStockes(@RequestBody List<Stock> stocks){
        List<Stock> finalList = new ArrayList<>();
        stocks.forEach(stock -> {
            finalList.add(this.stockService.saveStock(stock));
        });
        return finalList;
    }

    @PutMapping(value = "private/stocks/{id}")
    public Stock updateStock(@PathVariable Integer id, @RequestBody Stock stock){
        String msg = String.format("The Stock Id %s is different from the Url Id",stock.getId());
        Utils.validateUrlIdEqualsBodyId(id,stock.getId(),msg);
        return this.stockService.updateStock(stock);
    }

    @PutMapping(value = "private/stocks/mul")
    public List<Stock> updateStock(@RequestBody List<Stock> stockes){
        List<Stock> finalList = new ArrayList<>();
        stockes.forEach(stock -> {
            finalList.add(this.stockService.updateStock(stock));
        });
        return finalList;
    }

    @GetMapping(value = "public/stocks/")
    public List<Stock> getStock(){
        return this.stockService.getStock();
    }

    @GetMapping(value = "private/stocks/{id}")
    public Stock getStockById(@PathVariable Integer id){
        return this.stockService.getStockById(id);
    }

    @GetMapping(value = "public/stocks/family_products/{id}")
    public List<Stock> getStockByFamilyProduct(@PathVariable Integer id){
        return this.stockService.getStockByFamilyProduct(id);
    }

    @GetMapping(value = "public/stocks/quantity/")
    public Integer getStockByFamilyProduct(@RequestBody BranchOffice branchOffice, Product product){
        return this.stockService.getQuantityByBranchOfficeAndProduct(branchOffice,product);
    }

    @DeleteMapping(value = "private/stocks/{id}")
    public void deleteStock(@PathVariable Integer id, Stock stock){
        String msg = String.format("The Stock Id %s is different from the Url Id",stock.getId());
        Utils.validateUrlIdEqualsBodyId(id,stock.getId(),msg);
        this.stockService.deleteStock(stock);
    }
}
