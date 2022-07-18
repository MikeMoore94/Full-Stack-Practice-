package com.example.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResoucresNotFoundEx extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public ResoucresNotFoundEx(String message) {
		super(message);
	}
}