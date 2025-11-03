package com.justintime.schoolmanagement.model.responseDto;

import com.justintime.schoolmanagement.entity.Parent;
import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private List<AppUserRole> role; // Student, Staff, Teacher
    private String firstName;
    private String gender;
    private String lastName;
    private String guardianName;
    private String middleName;
    private String mode; //primary, nursery
    private String level;
    private Parent parent;
}
