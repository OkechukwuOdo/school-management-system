package com.justintime.schoolmanagement.model.requestDto;

import com.justintime.schoolmanagement.entity.ContactAddress;
import lombok.Data;

import java.util.Map;
@Data
public class SchoolProfileRequest {
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

}
