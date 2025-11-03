package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.model.requestDto.AuthenticationsRequest;
import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import com.justintime.schoolmanagement.model.requestDto.UserRequest;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.AuthenticationResponse;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import com.justintime.schoolmanagement.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class AppUSerController {
    private final AppUserService appUserService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<StaffResponseDto>> registerStaff(@RequestBody UserRequest userRequest){
        StaffResponseDto newStaff= appUserService.register(userRequest);
        return ResponseEntity.ok(ApiResponse.createdSuccess(newStaff));
    }
    @GetMapping("/hello")
    public ResponseEntity<?> authenticate(){

        return ResponseEntity.ok("Making way");
    }
}
