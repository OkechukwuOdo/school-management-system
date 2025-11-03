package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistration {
    private String courseId;
    private String courseCode;
    private String courseName;
    private int creditUnit;
    private Result result;
}
