package com.ship.ship.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UAuthException extends RuntimeException {

    public UAuthException(String message) {
        super(message);
    }
}
