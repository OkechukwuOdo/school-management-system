package com.justintime.schoolmanagement.paymentService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String email;
    private Double amount; // in kobo
    private String reference;
    private String currency = "NGN";
    private List<String> channels = List.of("card","bankTransfer","ussd","bank","mobileMoney");
    private String payment_purpose;
    private String user_id;
}
