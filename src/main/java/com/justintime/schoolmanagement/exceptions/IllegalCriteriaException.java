package com.justintime.schoolmanagement.exceptions;

public class IllegalCriteriaException extends RuntimeException{
    protected String message;

    public IllegalCriteriaException(String message) {
        super(message);
        this.message = message;
    }
}
