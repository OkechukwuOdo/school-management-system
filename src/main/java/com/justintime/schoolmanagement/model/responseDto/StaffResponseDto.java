package com.justintime.schoolmanagement.model.responseDto;

import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import com.justintime.schoolmanagement.entity.enumz.StaffType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class StaffResponseDto {
    private String id;
    private String email;
    private String phoneNumber;
    private List<AppUserRole> role; // Student, Staff, Teacher,admin,supper_admin
    private String firstName;
    private String gender;
    private String lastName;
    private String middleName;
    private String department;
    private String designation;
    private StaffType staffType;
    private BigDecimal salary;
    private LocalDate employmentDate;
}
