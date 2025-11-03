package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.AuthenticationResponse;
import com.justintime.schoolmanagement.service.UtilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/util")
public class UtilController {
    private final UtilService utilService;
    @PostMapping("/email-confirmation")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> validate( String email){
        log.info("Controller Entry........");
        return ResponseEntity.ok(ApiResponse.createdSuccess(utilService.validate(email)));
    }

    @PostMapping("/otp-verification")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> verifyOtp( String otp,String email){
        log.info("Controller Entry........");
        return ResponseEntity.ok(ApiResponse.createdSuccess(utilService.verifyOtp(otp,email)));
    }
}
