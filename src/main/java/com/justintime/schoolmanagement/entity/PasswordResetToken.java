package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "otp")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PasswordResetToken {
    @Id
    private Long id;

    private String token;

    private AppUser userId;

    private LocalDateTime expiryDate;
}
