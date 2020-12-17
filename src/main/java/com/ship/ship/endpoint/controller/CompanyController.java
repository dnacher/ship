package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.CompanyService;
import com.ship.ship.persistence.model.Company;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping(value = "/")
    public Company saveCompany(@RequestBody Company company){
        return this.companyService.saveCompany(company);
    }

    @PostMapping(value = "/mul")
    public List<Company> saveCompanyes(@RequestBody List<Company> companyes){
        List<Company> finalList = new ArrayList<>();
        companyes.forEach(company -> {
            finalList.add(this.companyService.saveCompany(company));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public Company updateCompany(@PathVariable Integer id, @RequestBody Company company){
        String msg = String.format("The Company Id %s is different from the Url Id",company.getId());
        Utils.validateUrlIdEqualsBodyId(id,company.getId(),msg);
        return this.companyService.updateCompany(company);
    }

    @PutMapping(value = "/mul")
    public List<Company> updateCompany(@RequestBody List<Company> companyes){
        List<Company> finalList = new ArrayList<>();
        companyes.forEach(company -> {
            finalList.add(this.companyService.updateCompany(company));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<Company> getCompany(){
        return this.companyService.getCompany();
    }

    @GetMapping(value = "/{id}")
    public Company getCompanyById(@PathVariable Integer id){
        return this.companyService.getCompanyById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCompany(@PathVariable Integer id, Company company){
        String msg = String.format("The Company Id %s is different from the Url Id",company.getId());
        Utils.validateUrlIdEqualsBodyId(id,company.getId(),msg);
        this.companyService.deleteCompany(company);
    }
}
