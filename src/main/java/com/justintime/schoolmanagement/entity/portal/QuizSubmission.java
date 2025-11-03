package com.justintime.schoolmanagement.entity.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "quiz_submissions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizSubmission {
    @Id
    private String id;
    private String quizId;
    private String studentId;
    private Map<String, Integer> answers; // questionId -> selectedOptionIndex
    private LocalDateTime submittedAt;
}
