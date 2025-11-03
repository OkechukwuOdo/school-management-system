package com.justintime.schoolmanagement.paymentService;

import lombok.Data;

@Data
public class WebhookResponse {
    private String event;
    private PaymentTransaction data;
}
