package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.SchoolProfile;
import com.justintime.schoolmanagement.model.requestDto.SchoolProfileRequest;
import com.justintime.schoolmanagement.model.requestDto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    SchoolProfile updateSchoolProfile(SchoolProfileRequest schoolProfileRequest);

    SchoolProfile getSchoolProfile();
}
