package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.FormPurchase;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.requestDto.FormPurchaseRequest;
import com.justintime.schoolmanagement.model.requestDto.VerifyFormPaymentRequest;
import org.springframework.stereotype.Service;

@Service
public interface WebBaseServices {
    String makeApplication(ApplicationRequestDto applicationRequestDto);

    Object purchaseForm(FormPurchaseRequest formPurchaseRequest);


    FormPurchase verifyFormPayment(VerifyFormPaymentRequest request);

}
