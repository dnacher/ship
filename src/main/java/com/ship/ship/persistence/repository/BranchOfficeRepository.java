package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.BranchOffice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchOfficeRepository  extends CrudRepository<BranchOffice,Integer> {
}
