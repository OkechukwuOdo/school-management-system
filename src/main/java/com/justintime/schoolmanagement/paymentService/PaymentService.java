package com.justintime.schoolmanagement.paymentService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface PaymentService {
    PaymentResponse initializePayment(PaymentRequest request);
    boolean verifyTransaction(String reference);
    String handlePaystackWebhook( HttpServletRequest request) throws IOException;
}
