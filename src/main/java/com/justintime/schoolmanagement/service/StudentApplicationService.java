package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.Applicants;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentApplicationService {
    StudentApplicationResponseDto applicationRegistration(ApplicationRequestDto applicationRequestDto);

//    List<StudentApplicationResponseDto> getAllApplication();
    StudentApplicationResponseDto  getApplicantById(String id);

    PaginationResponse<StudentApplicationResponseDto, StudentApplication> getAllApplication(int offset, int limit);

}
