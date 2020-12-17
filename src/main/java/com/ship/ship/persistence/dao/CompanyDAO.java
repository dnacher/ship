package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Company;
import com.ship.ship.persistence.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyDAO {

    @Autowired
    private CompanyRepository repository;

    public List<Company> getCompany(){
        List<Company> companies = new ArrayList<>();
        this.repository.findAll().forEach(company -> companies.add(company));
        return companies;
    }

    public Company getCompanyById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The company id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public Company saveCompany(Company company) throws ShipException {
        return this.repository.save(company);
    }

    public List<Company> saveCompanies(List<Company> companies) throws ShipException {
        List<Company> finalList= new ArrayList<>();
        this.repository.saveAll(companies).forEach(company -> {
            finalList.add(company);
        });
        return finalList;
    }

    public void deleteCompany(Company company){
        this.repository.delete(company);
    }

    public Company updateCompany(Company company) throws ShipException {
        if(company.getId()!=null){
            return this.repository.save(company);
        }else{
            String msg = String.format("Cannot update a company without an Id");
            throw new ShipException(msg);
        }
    }
}
