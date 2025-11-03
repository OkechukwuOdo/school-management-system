package com.justintime.schoolmanagement.entity.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("courses")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String id;
    private String title;
    private String description;
    private String level;
    private String code;   // "CSC201"
    // "Data Structures"
    private int creditUnit;
    private String semester;
}
