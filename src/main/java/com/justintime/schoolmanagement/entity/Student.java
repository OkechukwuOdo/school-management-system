package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import com.justintime.schoolmanagement.model.requestDto.StudentRequestDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Document(collection = "student")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Student extends AppUser{
    private SchoolCategory schoolCategory; //NURSERY, PRIMARY, SECONDARY, POLYTECHNIC
    private String currentClass; //"js2b"
    private LocalDate enrollmentDate;
    private String level;               // "SS2", "100 Level"
    @DBRef
    private Parent guardianName;
    private String matNumber="";
    private String departmentId="";
    private String facultyId="";
    private LocalDateTime updatedAt=LocalDateTime.now();
    private LocalDate graduationDate=LocalDate.now();
    private String admissionStatus="PENDING";
    private List<AcademicRecord> academicRecords = new ArrayList<>();


    private Student(StudentRequestDto studentRequestDto){
        super.setEmail(studentRequestDto.getEmail());
        super.setFirstName(studentRequestDto.getFirstName());
        super.setLastName(studentRequestDto.getLastName());
        super.setGender(studentRequestDto.getGender());
        super.setMiddleName(studentRequestDto.getMiddleName());
        super.setPassword(studentRequestDto.getPassword());
        super.setPhoneNumber(studentRequestDto.getPhoneNumber());
        super.setRole(List.of(AppUserRole.STUDENT));
        super.setDateOfBirth(studentRequestDto.getDateOfBirth());
        this.enrollmentDate=LocalDate.now();

    };
    public static Student studentInstance(StudentRequestDto studentRequestDto){

        return new Student(studentRequestDto);
    }

    private Student(AppUser appUser){
//        Student student = new Student(appUser);
        super.setEmail(appUser.getEmail());
        super.setFirstName(appUser.getFirstName());
        super.setLastName(appUser.getLastName());
        super.setGender(appUser.getGender());
        super.setMiddleName(appUser.getMiddleName());
        super.setPassword(appUser.getPassword());
        super.setId(appUser.getId());
        super.setRole(List.of(AppUserRole.STUDENT));
//        this.schoolCategory= student.getSchoolCategory().toSt;
//        this.currentYear=student.getCurrentYear();
        this.enrollmentDate=LocalDate.now();
    };
    public static Student studentFromAppUser(AppUser appUser){

        return new Student(appUser);
    }





}
