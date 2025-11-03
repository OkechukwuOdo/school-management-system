package com.justintime.schoolmanagement.entity.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document("quizQuestion")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctAnswerIndex;
}
