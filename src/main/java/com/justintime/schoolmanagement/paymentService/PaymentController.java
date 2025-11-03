package com.justintime.schoolmanagement.paymentService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/webhook")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<?> initiatePayment(@RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.initializePayment(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verifyTransaction")
    public ResponseEntity<?> verifyTransaction(@RequestBody String request) {
        boolean response = paymentService.verifyTransaction(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/paystack")
    public ResponseEntity<String> handlePaystackWebhook(HttpServletRequest request) throws IOException {
        return ResponseEntity.ok(paymentService.handlePaystackWebhook(request));
    }
}