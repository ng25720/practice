package com.productservice.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerRegistrationNotFoundException extends RuntimeException {
    public CustomerRegistrationNotFoundException(String message) {
        super(message);
    }
}
