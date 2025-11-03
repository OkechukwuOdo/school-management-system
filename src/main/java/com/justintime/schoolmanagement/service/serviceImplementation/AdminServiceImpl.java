package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.SchoolProfile;
import com.justintime.schoolmanagement.model.requestDto.SchoolProfileRequest;
import com.justintime.schoolmanagement.model.requestDto.UserRequest;
import com.justintime.schoolmanagement.repository.AdminRepository;
import com.justintime.schoolmanagement.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Override
    public SchoolProfile updateSchoolProfile(SchoolProfileRequest schoolProfileRequest) {
        return SchoolProfile.schoolProfileInstance(schoolProfileRequest);
    }

    @Override
    public SchoolProfile getSchoolProfile() {
        return adminRepository.findAll().getFirst();
    }
}
