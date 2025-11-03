package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.model.requestDto.SchoolProfileRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "staff")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class SchoolProfile {
    @Id
    private String id;
    private String title;
    private String moto;
    private String description;
    private String mission;
    private String vision;
    private String logo;
    private int totalStudent;
    private int totalStaff;
    private int department;
    private ContactAddress contactAddress;
    private Map<String,Object> metaData=Map.of();

    private SchoolProfile(SchoolProfileRequest schoolProfileRequest){
        this.moto=schoolProfileRequest.getMoto();
        this.description=schoolProfileRequest.getDescription();
        this.mission=schoolProfileRequest.getMission();
        this.vision=schoolProfileRequest.getVision();
        this.logo=schoolProfileRequest.getLogo();
        this.title=schoolProfileRequest.getTitle();
    }


    public static SchoolProfile schoolProfileInstance(SchoolProfileRequest schoolProfileRequest) {
        return new SchoolProfile(schoolProfileRequest);
    }
}
