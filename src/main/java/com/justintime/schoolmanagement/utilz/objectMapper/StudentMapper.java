package com.justintime.schoolmanagement.utilz.objectMapper;

import com.justintime.schoolmanagement.entity.Student;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import com.justintime.schoolmanagement.model.responseDto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentMapper {
    public static StudentResponse studentResponseInstance(Student student){
        return StudentResponse.builder()
                .email(student.getEmail())
                .id(student.getId())
                .phoneNumber(student.getPhoneNumber())
                .gender(student.getGender())
                .lastName(student.getLastName())
                .middleName(student.getMiddleName())
//                .mode(student.getMode().name())
                .level(student.getLastName())
                .firstName(student.getFirstName())
                .role(student.getRole())
                .build();
    }
    public static StudentApplicationResponseDto studentApplicationResponseInstance(StudentApplication studentApplication){
        return StudentApplicationResponseDto.builder()
                .id(studentApplication.getId())
                .applicants(studentApplication.getApplicants())
                .program(studentApplication.getProgram())
                .applicationDate(studentApplication.getApplicationDate())
                .build();
    }

}
