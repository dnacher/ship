package com.ship.ship.dto;

import com.ship.ship.persistence.model.User;
import com.ship.ship.persistence.model.UserType;

public class UserDTO {

    private String email;
    private String password;
    private UserType userType;

    public UserDTO(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public UserDTO(User user){
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.userType = user.getUserType();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
