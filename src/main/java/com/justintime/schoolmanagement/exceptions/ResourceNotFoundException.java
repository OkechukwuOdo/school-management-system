package com.justintime.schoolmanagement.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    protected String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}

