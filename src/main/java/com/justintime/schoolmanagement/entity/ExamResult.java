package com.justintime.schoolmanagement.entity;

import org.springframework.data.annotation.Id;

import java.util.Map;

public class ExamResult {
    @Id
    private String id;
    private String examId;
    private String studentId;
    private Map<String, String> answers; // questionId -> answer
    private int score;
    private String grade;
}
