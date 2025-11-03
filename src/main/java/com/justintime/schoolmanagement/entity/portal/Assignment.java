package com.justintime.schoolmanagement.entity.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("assignments")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id
    private String id;

    private String title;
    private String subject;
    private String description;

    private List<Question> questions;

    private SchoolCategory schoolCategory; // ENUM: NURSERY, PRIMARY, SECONDARY, UNIVERSITY

    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
}
