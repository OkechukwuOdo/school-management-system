package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "departments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Department {
    @Id
    private String id;
    private String name; // e.g. "Computer Science"
    @DBRef
    private Faculty faculty;
}
