package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.model.Product;
import com.ship.ship.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProduct(){
        List<Product> products = new ArrayList<>();
        this.repository.findAll().forEach(product -> products.add(product));
        return products;
    }

    public Product getProductById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The product id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

//    public List<Product> getProductByBranchOffice(BranchOffice branchOffice) throws ShipException {
//        List<Product> products = this.repository.findByBranchOfficeAndActive(branchOffice,true);
//        if(products==null){
//            String msg = String.format("The product branch office %s does not exist", branchOffice.getId().toString());
//            throw new ShipException(msg);
//        };
//        return products;
//    }

    public List<Product> getProductByFamilyProduct(FamilyProduct familyProduct) throws ShipException {
        List<Product> products = this.repository.findByFamilyProductAndActive(familyProduct,true);
        if(products==null){
            String msg = String.format("The product family product %s does not exist", familyProduct.getId().toString());
            throw new ShipException(msg);
        };
        return products;
    }

    public Product saveProduct(Product product) throws ShipException {
        return this.repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) throws ShipException {
        List<Product> finalList= new ArrayList<>();
        this.repository.saveAll(products).forEach(product -> {
            finalList.add(product);
        });
        return finalList;
    }

    public void deleteProduct(Product product){
        this.repository.delete(product);
    }

    public Product updateProduct(Product product) throws ShipException {
        if(product.getId()!=null){
            return this.repository.save(product);
        }else{
            String msg = String.format("Cannot update a product without an Id");
            throw new ShipException(msg);
        }
    }
}
