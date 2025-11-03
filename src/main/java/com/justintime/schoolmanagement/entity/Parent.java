package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "parent")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Parent {
    @Id
    private String id;
    private String fullName;
    private String phone;
    private String email;// Reference to the student
    private ContactAddress contactInformation;
    private List<String> childrenIds;
}
