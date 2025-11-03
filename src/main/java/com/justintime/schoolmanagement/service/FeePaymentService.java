package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.FeePayment;
import com.justintime.schoolmanagement.entity.FeeType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeePaymentService {
    FeeType createFeeType(FeeType feeType);
    FeePayment recordPayment(FeePayment payment);
    List<FeePayment> getPaymentsByStudent(String studentId);
    double getOutstandingBalance(String studentId, String feeTypeId);
}
