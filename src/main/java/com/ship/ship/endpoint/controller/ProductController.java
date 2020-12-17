package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.ProductService;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.model.FamilyProduct;
import com.ship.ship.persistence.model.Product;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(value = "private/products/")
    public Product saveProduct(@RequestBody Product product){
        return this.productService.saveProduct(product);
    }

    @PostMapping(value = "private/products/mul")
    public List<Product> saveProductes(@RequestBody List<Product> products){
        List<Product> finalList = new ArrayList<>();
        products.forEach(product -> {
            finalList.add(this.productService.saveProduct(product));
        });
        return finalList;
    }

    @PutMapping(value = "private/products/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product){
        String msg = String.format("The Product Id %s is different from the Url Id",product.getId());
        Utils.validateUrlIdEqualsBodyId(id,product.getId(),msg);
        return this.productService.updateProduct(product);
    }

    @PutMapping(value = "private/products/mul")
    public List<Product> updateProduct(@RequestBody List<Product> products){
        List<Product> finalList = new ArrayList<>();
        products.forEach(product -> {
            finalList.add(this.productService.updateProduct(product));
        });
        return finalList;
    }

    @GetMapping(value = "public/products/")
    public List<Product> getProduct(){
        return this.productService.getProduct();
    }

    @GetMapping(value = "public/products/{id}")
    public Product getProductById(@PathVariable Integer id){
        return this.productService.getProductById(id);
    }

    @GetMapping(value = "public/products/family_product/")
    public List<Product> getProductById(@RequestBody FamilyProduct familyProduct){
        return this.productService.getProductByFamilyProduct(familyProduct);
    }

//    @GetMapping(value = "/branch_office/")
//    public List<Product> getProductByBranchOffice(@RequestBody BranchOffice branchOffice){
//        return this.productService.getProductByBranchOffice(branchOffice);
//    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Integer id, Product product){
        String msg = String.format("The Product Id %s is different from the Url Id",product.getId());
        Utils.validateUrlIdEqualsBodyId(id,product.getId(),msg);
        this.productService.deleteProduct(product);
    }
}
