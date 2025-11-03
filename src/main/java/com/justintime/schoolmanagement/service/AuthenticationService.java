package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.model.requestDto.AuthenticationsRequest;
import com.justintime.schoolmanagement.model.requestDto.RefreshRequest;
import com.justintime.schoolmanagement.model.responseDto.AuthenticationResponse;
import com.justintime.schoolmanagement.model.responseDto.TokenResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationsRequest requestDto);

    AuthenticationResponse refreshToken(RefreshRequest req);

    void sendResetLink(String email) throws IOException;

    void resetPassword(String token, String newPassword);

    void changePassword(String token, String newPassword);

}
