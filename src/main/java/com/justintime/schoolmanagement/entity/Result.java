package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parent")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Result {
    private double score;   // e.g. 75
    private String grade;   // A, B, C, D, F
    private double gradePoint;
}
