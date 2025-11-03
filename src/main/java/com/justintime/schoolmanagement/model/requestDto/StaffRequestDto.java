package com.justintime.schoolmanagement.model.requestDto;

import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import com.justintime.schoolmanagement.entity.enumz.StaffType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class StaffRequestDto {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
    private String phoneNumber;// Student, Staff, Teacher,admin,supper_admin
    private String firstName;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    private String gender;
    private String lastName;
    private String middleName;
    private String department;
    private AppUserRole appUserRole;
    private String designation;
    private BigDecimal salary;
    private StaffType staffType;
    private LocalDate employmentDate;
}
