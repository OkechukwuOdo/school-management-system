package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import com.justintime.schoolmanagement.entity.enumz.StaffType;
import com.justintime.schoolmanagement.entity.portal.Course;
import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "staff")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Staff extends AppUser{
    private LocalDate employmentDate;
    private String staffId;
    private String employmentStatus;       // ACTIVE, RETIRED, SUSPENDED, RESIGNED
    private String employmentType;
    private String designation; // e.g., TEACHER, PRINCIPAL
    private BigDecimal salary;
    private PayRoll payRoll;
    private StaffType staffType;
    private String departmentId;
    @DBRef(lazy = true)
    private List<AcademicAssignment> assignments = new ArrayList<>();

    @DBRef
    private Department department;

    private Staff(StaffRequestDto staffRequest){
        super.setEmail(staffRequest.getEmail());
        super.setGender(staffRequest.getGender());
        super.setRole(List.of(AppUserRole.STAFF));
        super.setFirstName(staffRequest.getFirstName());
        super.setPhoneNumber(staffRequest.getPhoneNumber());
        super.setLastName(staffRequest.getLastName());
        super.setMiddleName(staffRequest.getMiddleName());
        super.setPassword(staffRequest.getPassword());
        super.setDateOfBirth(staffRequest.getEmploymentDate());
        this.designation=staffRequest.getDepartment();
        this.setDesignation(staffRequest.getDesignation());
        this.setSalary(staffRequest.getSalary());
        this.salary=staffRequest.getSalary();
        this.employmentDate=staffRequest.getEmploymentDate();
        this.setStaffType(staffRequest.getStaffType());
    }

    public static Staff staffInstanceFromRequest(StaffRequestDto staffRequest){
        return new Staff(staffRequest);
    }


}
