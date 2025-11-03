package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.FeePayment;
import com.justintime.schoolmanagement.entity.FeeType;
import com.justintime.schoolmanagement.model.requestDto.FeePaymentRequest;
import com.justintime.schoolmanagement.model.requestDto.FeeTypeRequest;
import com.justintime.schoolmanagement.service.FeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/fee")
public class FeeController {
    private final FeeService feeService;

    @PostMapping("/types")
    public ResponseEntity<FeeType> createType(@RequestBody FeeTypeRequest feeType) {
        return ResponseEntity.ok(feeService.createFeeType(feeType));
    }

    @PostMapping("/fee-payments")
    public ResponseEntity<?> makePayment(@RequestBody FeePaymentRequest payment) {
        return ResponseEntity.ok(feeService.makePayment(payment));
    }

    @GetMapping("/payments/{studentId}")
    public ResponseEntity<List<FeePayment>> studentFeePayments(@PathVariable String studentId) {
        return ResponseEntity.ok(feeService.getPaymentsByStudent(studentId));
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> balance(@RequestParam String studentId,
                                          @RequestParam String feeTypeId) {
        return ResponseEntity.ok(feeService.getOutstandingBalance(studentId, feeTypeId));
    }
}
