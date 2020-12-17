package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.User;
import com.ship.ship.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class UserDAO {

    @Autowired
    private UserRepository repository;

    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        this.repository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User findByEmail(String email){
        return this.repository.findByEmail(email);
    }

    public Integer countByEmail(String email){
        return this.repository.countByEmail(email);
    }

    public User getUserByUserAndPassword(String userName, String password){
        return this.repository.findByUserNameAndPassword(userName,password);
    }

    public User getUserById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The user id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public User saveUser(User user) throws ShipException {
        return this.repository.save(user);
    }

    public List<User> saveUsers(List<User> users) throws ShipException {
        List<User> finalList= new ArrayList<>();
        this.repository.saveAll(users).forEach(user -> {
            finalList.add(user);
        });
        return finalList;
    }

    public void deleteUser(User user){
        this.repository.delete(user);
    }

    public User updateUser(User user) throws ShipException {
        if(user.getId()!=null){
            return this.repository.save(user);
        }else{
            String msg = String.format("Cannot update a user without an Id");
            throw new ShipException(msg);
        }
    }
}