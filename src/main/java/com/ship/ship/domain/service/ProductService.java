package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.ProductDAO;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> getProduct(){
        return productDAO.getProduct();
    }

    public Product getProductById(Integer id){
        return productDAO.getProductById(id);
    }

//    public List<Product> getProductByBranchOffice(BranchOffice branchOffice){ return productDAO.getProductByBranchOffice(branchOffice); }

    public List<Product> getProductByFamilyProduct(FamilyProduct familyProduct) { return productDAO.getProductByFamilyProduct(familyProduct); }

    public Product saveProduct(Product product){
        return productDAO.saveProduct(product);
    }

    public Product updateProduct(Product product){
        return productDAO.updateProduct(product);
    }

    public void deleteProduct(Product product){
        productDAO.deleteProduct(product);
    }
}
