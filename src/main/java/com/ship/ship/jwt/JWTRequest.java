package com.ship.ship.jwt;

import com.ship.ship.dto.UserDTO;
import com.ship.ship.persistence.model.User;

public class JWTRequest {

    private UserDTO user;

    public JWTRequest(){}

    public JWTRequest(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void createUser(User user){

    }
}
