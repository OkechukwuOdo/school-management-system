package com.justintime.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.justintime.schoolmanagement.entity.enumz.FeeStatus;
import com.justintime.schoolmanagement.paymentService.PaymentTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "student_fees")
//@Document(collection = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeePayment {
    @Id
    private String id;

    @DBRef
    private Student student;

    @DBRef
    private FeeSchedule feeSchedule;

    private BigDecimal totalFee;
    private BigDecimal amountPaid = BigDecimal.ZERO;
    private BigDecimal balance;
    private String paymentStatus = "PENDING"; // PENDING, PARTIALLY_PAID, PAID, OVERDUE

    private List<PaymentTransaction> transactions = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
