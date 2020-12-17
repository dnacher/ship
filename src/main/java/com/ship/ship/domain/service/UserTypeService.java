package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.UserTypeDAO;
import com.ship.ship.persistence.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserTypeService {

    @Autowired
    private UserTypeDAO userTypeDAO;

    public List<UserType> getUserType(){
        return userTypeDAO.getUserType();
    }

    public UserType getUserTypeById(Integer id){
        return userTypeDAO.getUserTypeById(id);
    }

    public UserType saveUserType(UserType userType){
        return userTypeDAO.saveUserType(userType);
    }

    public UserType updateUserType(UserType userType){
        return userTypeDAO.updateUserType(userType);
    }

    public void deleteUserType(UserType userType){
        userTypeDAO.deleteUserType(userType);
    }
}
