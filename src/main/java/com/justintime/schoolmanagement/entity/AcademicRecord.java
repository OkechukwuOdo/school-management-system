package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "parent")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AcademicRecord {
    private int year;        // e.g. 2025
    private int semester_term;
    private String level;
    private String departmentId;// 1 or 2
    private List<CourseRegistration> regCourses = new ArrayList<>();
    private double gpa;
}
