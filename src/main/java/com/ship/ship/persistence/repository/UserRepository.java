package com.ship.ship.persistence.repository;

import com.ship.ship.exceptions.UAuthException;
import com.ship.ship.persistence.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUserNameAndPassword(String userName, String password) throws UAuthException;
    User findByEmail(String email) throws UAuthException;
    Integer countByEmail(String email);

}
