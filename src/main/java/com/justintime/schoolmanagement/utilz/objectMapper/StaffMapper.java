package com.justintime.schoolmanagement.utilz.objectMapper;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Staff;
import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StaffMapper {
    static public StaffResponseDto staffResponse(Staff staff){
        return  StaffResponseDto.builder().email(staff.getEmail())
                .id(staff.getId())
                .phoneNumber(staff.getPhoneNumber())
                .gender(staff.getGender())
                .middleName(staff.getMiddleName())
                .designation(staff.getDesignation())
                .firstName(staff.getFirstName())
                .salary(staff.getSalary())
                .employmentDate(staff.getEmploymentDate())
                .lastName(staff.getLastName())
                .role(staff.getRole())
//                .department(staff.getDepartment())
                .staffType(staff.getStaffType())
                .build();
    }
}
