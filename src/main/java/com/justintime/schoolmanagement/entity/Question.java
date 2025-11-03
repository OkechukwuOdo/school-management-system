package com.justintime.schoolmanagement.entity;

import java.util.List;

public class Question {
    private String questionText;
    private String type; // MCQ, THEORY, ESSAY
    private List<String> options; // if MCQ
    private String correctAnswer;
    private int marks;
}
