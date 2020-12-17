package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends CrudRepository<Company,Integer> {
}
