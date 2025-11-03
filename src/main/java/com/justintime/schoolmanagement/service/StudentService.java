package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Student;
import com.justintime.schoolmanagement.model.requestDto.StudentRequestDto;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import com.justintime.schoolmanagement.model.responseDto.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    StudentResponse registerStudent(StudentRequestDto studentRequestDto);
    PaginationResponse<StudentResponse, Student> getAllStudent(int offset, int limit);

    String deleteAStudent(String id);
    StudentResponse getAStudentById(String staffId);

}
