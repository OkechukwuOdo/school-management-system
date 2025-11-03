package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.model.requestDto.AuthenticationsRequest;
import com.justintime.schoolmanagement.model.requestDto.RefreshRequest;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.AuthenticationResponse;
import com.justintime.schoolmanagement.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> authenticate(@RequestBody AuthenticationsRequest requestDto){
        log.info("Controller Entry........");
        return ResponseEntity.ok(ApiResponse.createdSuccess(authenticationService.authenticate(requestDto)));
    }
    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(@RequestBody RefreshRequest req) {
        return ResponseEntity.ok(authenticationService.refreshToken(req));
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody String email) throws IOException {
        authenticationService.sendResetLink(email);
        return ResponseEntity.ok("Reset link sent.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> payload) {
        authenticationService.resetPassword(payload.get("token"), payload.get("newPassword"));
        return ResponseEntity.ok("Password updated.");
    }
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> payload) {
        authenticationService.changePassword(payload.get("token"), payload.get("newPassword"));
        return ResponseEntity.ok("Password updated.");
    }
}
