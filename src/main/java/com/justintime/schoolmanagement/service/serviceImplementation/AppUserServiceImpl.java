package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import com.justintime.schoolmanagement.model.requestDto.UserRequest;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import com.justintime.schoolmanagement.repository.AppUserRepository;
import com.justintime.schoolmanagement.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    @Override
    public StaffResponseDto register(UserRequest userRequest) {
        return null;
    }
}
