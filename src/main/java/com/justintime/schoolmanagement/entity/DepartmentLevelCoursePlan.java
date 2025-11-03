package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.portal.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentLevelCoursePlan {
    private String level;     // "100 Level", "200 Level"
    private String session;   // e.g., "2024/2025"
    @DBRef
    private List<Course> courses;
}
