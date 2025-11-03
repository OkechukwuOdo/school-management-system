package com.justintime.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Document(collection = "parent")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Payment {
    private String method; // CARD, BANK_TRANSFER, CASH
    private BigDecimal amount;
    private String transactionId;
    private LocalDateTime date;
    private boolean verifiedByAdmin = false;
}
