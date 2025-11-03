package com.justintime.schoolmanagement.model.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeePaymentRequest {
    private String paymentId;
    private String studentId;
    private String amount;
}
