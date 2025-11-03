package com.justintime.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.justintime.schoolmanagement.entity.enumz.AppUserRole;

import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import com.justintime.schoolmanagement.model.requestDto.StudentRequestDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    private String id;
    private String email;
    private String profilePix;
    private String password;
    private String phoneNumber;
    private List<AppUserRole> role; // Student, Staff, Teacher,admin,supper_admin
    private String firstName;
    private String gender;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;
    private ContactAddress contactInformation;
    private LocalDateTime createdAt;


    private AppUser(StudentRequestDto studentRequestDto){
        this.setEmail(studentRequestDto.getEmail());
        this.setFirstName(studentRequestDto.getFirstName());
        this.setLastName(studentRequestDto.getLastName());
        this.setGender(studentRequestDto.getGender());
        this.setMiddleName(studentRequestDto.getMiddleName());
        this.setPassword(studentRequestDto.getPassword());
        this.setPhoneNumber(studentRequestDto.getPhoneNumber());
        this.setRole(List.of(AppUserRole.STUDENT));
        this.setDateOfBirth(LocalDate.now());

    };
    public static AppUser userInstance(StudentRequestDto studentRequestDto){

        return new AppUser(studentRequestDto);
    }
    private AppUser(StaffRequestDto staffRequestDto){
        this.setEmail(staffRequestDto.getEmail());
        this.setFirstName(staffRequestDto.getFirstName());
        this.setLastName(staffRequestDto.getLastName());
        this.setGender(staffRequestDto.getGender());
        this.setMiddleName(staffRequestDto.getMiddleName());
        this.setPassword(staffRequestDto.getPassword());
        this.setPhoneNumber(staffRequestDto.getPhoneNumber());
        this.setRole(List.of(AppUserRole.STUDENT));
        this.setDateOfBirth(LocalDate.now());

    };
    public static AppUser userInstance(StaffRequestDto staffRequestDto){

        return new AppUser(staffRequestDto);
    }
}
