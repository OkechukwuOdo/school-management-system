package com.justintime.schoolmanagement.emailService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetail {
    private String toEmail;
    private String subject;
    private String emailContent;
}
