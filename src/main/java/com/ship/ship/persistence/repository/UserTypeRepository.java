package com.ship.ship.persistence.repository;

import com.ship.ship.persistence.model.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType,Integer> {
}
