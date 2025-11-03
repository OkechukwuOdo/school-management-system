package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "faculties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    private String id;
    private String name;  // e.g. "Faculty of Science"
    private List<Department> departments = new ArrayList<>();
}
