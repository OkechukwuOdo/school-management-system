package com.justintime.schoolmanagement.exceptions;

import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> resourceNotFoundException(ResourceNotFoundException ex) {
        ApiResponse<?> response = ApiResponse.errorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,  HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IllegalCriteriaException.class)
    public ResponseEntity<ApiResponse<?>> illegalCriteriaException(IllegalCriteriaException ex) {
        ApiResponse<?> response = ApiResponse.errorResponse(ex.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
