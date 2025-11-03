package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.enumz.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormPurchase {

    @Id
    private String id; // MongoDB prefers String IDs or ObjectId

    private String email;
    @DBRef
    private Program program; // Referencing the SchoolForm document

    private String paymentReference;
    private BigDecimal amount;

    private PaymentStatus status; // PENDING, SUCCESSFUL, FAILED

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime purchasedAt;


    private String userId;

    private String currency = "NGN";
   // e.g. "PAYSTACK"
    private String channel;          // "card", "bank", "ussd", etc.

    private LocalDateTime updatedAt;
}
