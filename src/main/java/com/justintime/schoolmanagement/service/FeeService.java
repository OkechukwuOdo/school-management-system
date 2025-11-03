package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.FeePayment;
import com.justintime.schoolmanagement.entity.FeeType;
import com.justintime.schoolmanagement.model.requestDto.FeePaymentRequest;
import com.justintime.schoolmanagement.model.requestDto.FeeTypeRequest;
import com.justintime.schoolmanagement.model.requestDto.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeeService {


    Object makePayment(FeePaymentRequest payment);

    FeeType createFeeType(FeeTypeRequest feeType);

    List<FeePayment> getPaymentsByStudent(String studentId);

    Double getOutstandingBalance(String studentId, String feeTypeId);
}
