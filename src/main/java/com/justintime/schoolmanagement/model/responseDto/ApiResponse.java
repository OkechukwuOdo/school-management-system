package com.justintime.schoolmanagement.model.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>{
    private String message;
    private HttpStatus statusCode;
    private boolean status;
    private final LocalDateTime time = LocalDateTime.now();
    private T data;

    public static  <T> ApiResponse<T> buildSuccessTxn(T data){
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatusCode(HttpStatus.OK);
        response.setMessage("Success");
        response.setStatus(true);
        response.setData(data);
        return response;
    }
    public static  <T>ApiResponse<T> createdSuccess(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatusCode(HttpStatus.CREATED);
        response.setMessage("Success");
        response.setStatus(true);
        response.setData(data);
        return response;
    }
    public static  <T>ApiResponse<T> fetchSuccess(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatusCode(HttpStatus.FOUND);
        response.setMessage("Success");
        response.setStatus(true);
        response.setData(data);
        return response;
    }
    public static <T>ApiResponse<T> errorResponse(String errMsg, HttpStatus httpStatus){
        ApiResponse <T> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(errMsg);
        apiResponse.setStatusCode(httpStatus);
        return apiResponse;
    }
    public static <T>ApiResponse<T> deleteResponse(T data){
        ApiResponse <T> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Deleted");
        apiResponse.setStatusCode(HttpStatus.GONE);
        apiResponse.setData(data);
        return apiResponse;
    }
}
