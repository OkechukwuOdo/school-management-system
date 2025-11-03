package com.justintime.schoolmanagement.model.requestDto;

import lombok.Data;

@Data
public class ProgramPaymentRequest {
    private String email;
    private String programId;
}
