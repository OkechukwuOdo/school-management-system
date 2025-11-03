package com.justintime.schoolmanagement.paymentService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private boolean status;
    private String message;
    private PaymentData data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class PaymentData {
        private String authorization_url;
        private String access_code;
        private String reference;
    }
}
