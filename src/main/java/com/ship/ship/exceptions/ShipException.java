package com.ship.ship.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ShipException extends RuntimeException{

    private int code;

    public ShipException(String message) {
        super(message);
    }

    public ShipException(int code, String message) {
        super(message);
        this.code = code;
    }
}
