package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import com.justintime.schoolmanagement.entity.portal.ClassSubject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.security.auth.Subject;
import java.util.List;
@Document(collection = "review")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class SchoolClass {
    private String id;
    private String name; // e.g., "Primary 1B", "JSS 2D"
    private SchoolCategory category; // PRIMARY or SECONDARY
    @DBRef
    private List<ClassSubject> subjects; // Subjects for this class

    private String session;
}
