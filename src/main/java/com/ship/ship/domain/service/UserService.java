package com.ship.ship.domain.service;

import com.ship.ship.exceptions.UAuthException;
import com.ship.ship.dto.UserDTO;
import com.ship.ship.persistence.model.User;

import java.util.List;

public interface UserService {

    UserDTO validateUser(UserDTO userDTO) throws UAuthException;
    User registerUser(User user) throws UAuthException;
    List<User> getUser();
    User getUserById(Integer id);
    void deleteUser(User user);
    UserDTO Login(UserDTO user);
}
