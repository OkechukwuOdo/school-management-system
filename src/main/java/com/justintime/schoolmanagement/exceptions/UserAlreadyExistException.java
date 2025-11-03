package com.justintime.schoolmanagement.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    protected String message;

    public UserAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
