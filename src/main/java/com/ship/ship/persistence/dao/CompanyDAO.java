package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Company;
import com.ship.ship.persistence.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyDAO {

  private final Logger log = LoggerFactory.getLogger(CompanyDAO.class.getName());
  @Autowired private CompanyRepository repository;

  public List<Company> getCompany() {
    log.info("getCompany");
    List<Company> companies = new ArrayList<>();
    this.repository.findAll().forEach(company -> companies.add(company));
    return companies;
  }

  public Company getCompanyById(Integer id) throws ShipException {
    log.info("getCompanyById {0}", id);
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> {
              String msg = String.format("The company id %s does not exist", id.toString());
              log.error(msg);
              return new ShipException(msg);
            });
  }

  public Company saveCompany(Company company) throws ShipException {
    log.info("saveCompany ", company);
    return this.repository.save(company);
  }

  public List<Company> saveCompanies(List<Company> companies) throws ShipException {
    List<Company> finalList = new ArrayList<>();
    this.repository
        .saveAll(companies)
        .forEach(
            company -> {
              finalList.add(company);
            });
    return finalList;
  }

  public void deleteCompany(Company company) {
    log.info("deleteCompany ", company);
    this.repository.delete(company);
  }

  public Company updateCompany(Company company) throws ShipException {
    if (company.getId() != null) {
      log.info("updateCompany", company);
      return this.repository.save(company);
    } else {
      String msg = String.format("Cannot update a company without an Id");
      log.error(msg);
      throw new ShipException(msg);
    }
  }
}
