package com.justintime.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applicants")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Applicants {
    private String id;
    private String email;
    private String registrationPin;
    private String programType;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String address;
    private Applicants(ApplicationRequestDto applicationRequestDto){
        this.email=applicationRequestDto.getEmail();
        this.firstName=applicationRequestDto.getFirstName();
        this.lastName=applicationRequestDto.getLastName();
        this.address=applicationRequestDto.getAddress();
        this.phoneNumber=applicationRequestDto.getPhoneNumber();
    }
    public static Applicants applicantInstanceFromRequest(ApplicationRequestDto applicationRequestDto){
        return new Applicants(applicationRequestDto);
    }
}
