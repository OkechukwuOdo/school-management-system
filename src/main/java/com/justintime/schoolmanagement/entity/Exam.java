package com.justintime.schoolmanagement.entity;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

public class Exam {
    @Id
    private String id;
    private String courseId;
    private String departmentId;
    private String level;
    private String title;        // e.g., "Midterm Exam"
    private String type;         // WRITTEN, ONLINE, PRACTICAL
    private LocalDateTime date;
    private int durationMinutes;
    private boolean published;

    private List<Question> questions;
}
