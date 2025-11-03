package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.model.responseDto.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface UtilService {
    AuthenticationResponse validate(String email);

    AuthenticationResponse verifyOtp(String otp,String email);

}
