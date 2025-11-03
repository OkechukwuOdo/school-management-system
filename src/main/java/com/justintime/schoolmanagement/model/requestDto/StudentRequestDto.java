package com.justintime.schoolmanagement.model.requestDto;

import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDto {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    private String phoneNumber;
    private AppUserRole role; // Student, Staff, Teacher
    private String firstName;
    private String gender;
    private String lastName;
    private String middleName;
    private String guardianName;
    private String mode; //primary, nursery
    private Integer level;
    private LocalDate dateOfBirth;
}
