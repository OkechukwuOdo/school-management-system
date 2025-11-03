package com.justintime.schoolmanagement.paymentService;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaymentTransaction {
    @Id
    private String method; // CARD, BANK_TRANSFER, CASH
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String status;
    private String reference;
    private String customer_email;
}
