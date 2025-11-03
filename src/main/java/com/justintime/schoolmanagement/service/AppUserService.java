package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import com.justintime.schoolmanagement.model.requestDto.UserRequest;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    StaffResponseDto register(UserRequest userRequest);
}
