package com.ship.ship.jwt;

import com.ship.ship.dto.UserDTO;

import java.util.Date;

public class JWTResponse {

    private String token;
    private Date expirationDate;
    private UserDTO user;

    public JWTResponse(){}

    public JWTResponse(String token, Date expirationDate, UserDTO user) {
        this.token = token;
        this.expirationDate = expirationDate;
        this.user= user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
