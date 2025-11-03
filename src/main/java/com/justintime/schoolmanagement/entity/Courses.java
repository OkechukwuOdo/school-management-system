package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "courses")
public class Courses {
    private String id;
    private String code;       // e.g. CSC101
    private String name;
    private String description;// e.g. Introduction to Programming
    private int creditUnit;
    private String level;// e.g. 3// 3 units
    @DBRef
    private Department department;
}
