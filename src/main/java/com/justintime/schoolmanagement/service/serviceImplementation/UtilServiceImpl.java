package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.model.responseDto.AuthenticationResponse;
import com.justintime.schoolmanagement.service.UtilService;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {
    @Override
    public AuthenticationResponse validate(String email) {
        return null;
    }

    @Override
    public AuthenticationResponse verifyOtp(String otp, String email) {
        return null;
    }
}
