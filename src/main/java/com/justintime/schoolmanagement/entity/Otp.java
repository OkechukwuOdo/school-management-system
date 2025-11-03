package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "otp")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Otp {
    @Id
    private String id;
    private String otp;
    private String email;

}
