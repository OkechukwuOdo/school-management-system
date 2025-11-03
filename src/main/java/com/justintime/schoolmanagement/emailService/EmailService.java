package com.justintime.schoolmanagement.emailService;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface EmailService {
    void sendMail(EmailDetail emailDetail) throws IOException;
}
