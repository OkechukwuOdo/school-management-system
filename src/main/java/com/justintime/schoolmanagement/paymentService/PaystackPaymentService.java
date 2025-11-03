package com.justintime.schoolmanagement.paymentService;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaystackPaymentService implements PaymentService {
    private String paystackKey;
    private final TransactionRepository transactionRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public PaymentResponse initializePayment(PaymentRequest request) {
        String url = "https://api.paystack.co/transaction/initialize";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(paystackKey);

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("payment_purpose", request.getPayment_purpose());
        metadata.put("user_ref", request.getUser_id());

        Map<String, Object> payload = new HashMap<>();
        payload.put("email", request.getEmail());
        payload.put("amount", request.getAmount()*100);
        payload.put("reference",request.getReference());
        payload.put("metadata", metadata);
        HttpEntity< Map<String, Object> > entity = new HttpEntity<>(payload, headers);
        ResponseEntity<PaymentResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, PaymentResponse.class);
        return response.getBody();
    }

    @Override
    public boolean verifyTransaction(String reference) {
        String url = "https://api.paystack.co/transaction/verify/" + reference;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(paystackKey);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, Map.class);

        return response.getBody().get("status").equals(Boolean.TRUE);
    }

    @Override
    public String handlePaystackWebhook(HttpServletRequest request) throws IOException {
        String signature = request.getHeader("x-paystack-signature");
        String body = new BufferedReader(new InputStreamReader(request.getInputStream()))
                .lines()
                .collect(Collectors.joining("\n"));

        boolean isVerified = PaystackUtil.verifySignature(body, signature, "sk_test_your_paystack_secret_key");
        if (!isVerified) {
            return "Invalid signature";
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WebhookResponse event = objectMapper.readValue(body, WebhookResponse.class);

            if ("charge.success".equals(event.getEvent())) {
                String reference = event.getData().getReference();
                Optional<PaymentTransaction> optionalPayment = transactionRepository.findByReference(reference);

                if (optionalPayment.isPresent()) {
                    PaymentTransaction payment = optionalPayment.get();
                    payment.setStatus("COMPLETED");
                    payment.setPaymentDate(LocalDate.now());
                    transactionRepository.save(payment);

                    return ("Payment confirmed and booking updated");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ("Webhook error");
        }

        return ("Ignored");
    }
}
