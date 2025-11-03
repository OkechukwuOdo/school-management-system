package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.portal.Course;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Document("teaching_assignments")
public class AcademicAssignment {
    @Id
    private String id;
    @DBRef
    private Staff staff;  // The academic staff
    @DBRef
    private Course course; // The course being taught
    @DBRef
    private Department department; // Which department it is under
    private String academicYear;   // e.g., "2023/2024"
    private String level;          // e.g., "100L", "200L", "SS1"
    private String semester;       // e.g., "First Semester", "Second Semester"
    private LocalDate startDate;   // When teaching started
    private LocalDate endDate;     // When teaching ended
    private String role;           // LECTURER, COURSE_COORDINATOR, ASSISTANT
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
