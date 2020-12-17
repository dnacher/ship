package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.CompanyDAO;
import com.ship.ship.persistence.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    public List<Company> getCompany(){
        return companyDAO.getCompany();
    }

    public Company getCompanyById(Integer id){
        return companyDAO.getCompanyById(id);
    }

    public Company saveCompany(Company company){
        return companyDAO.saveCompany(company);
    }

    public Company updateCompany(Company company){
        return companyDAO.updateCompany(company);
    }

    public void deleteCompany(Company company){
        companyDAO.deleteCompany(company);
    }
}
