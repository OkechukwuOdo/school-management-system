package com.justintime.schoolmanagement.model.requestDto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VerifyFormPaymentRequest {
    private String email;
    private String referenceCode;
}
