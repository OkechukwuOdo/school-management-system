package com.justintime.schoolmanagement.model.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class FormPurchaseRequest {
    private String programId;
    private String applicantEmail;
}
