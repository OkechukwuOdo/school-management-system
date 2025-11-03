package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.Applicants;
import com.justintime.schoolmanagement.entity.FormPurchase;
import com.justintime.schoolmanagement.entity.Program;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.entity.enumz.PaymentStatus;
import com.justintime.schoolmanagement.exceptions.ResourceNotFoundException;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.requestDto.FormPurchaseRequest;
import com.justintime.schoolmanagement.model.requestDto.VerifyFormPaymentRequest;
import com.justintime.schoolmanagement.paymentService.PaymentRequest;
import com.justintime.schoolmanagement.paymentService.PaymentService;
import com.justintime.schoolmanagement.repository.FormPurchaseRepository;
import com.justintime.schoolmanagement.repository.ProgramRepository;
import com.justintime.schoolmanagement.service.WebBaseServices;
import com.justintime.schoolmanagement.utilz.config.HelperFunction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebBaseServicesImpl implements WebBaseServices {
    private final ProgramRepository programRepository;
    private final FormPurchaseRepository formPurchaseRepository;
    private final PaymentService paymentService;
    @Override
    public String makeApplication(ApplicationRequestDto applicationRequestDto) {
        Program program= Program.builder().build();
        Applicants applicants= Applicants.builder().build();
        StudentApplication.builder()
                .applicants(applicants)
                .program(program)
                .applicationDate(LocalDate.now())
                .build();
        return "";
    }

    @Override
    public Object purchaseForm(FormPurchaseRequest formPurchaseRequest) {
      Program program=  programRepository.findById(formPurchaseRequest.getProgramId())
                .orElseThrow(() -> new ResourceNotFoundException("Form not found"));
        BigDecimal amount = program.getPurchasePrice();
        int amountInKobo = amount.multiply(BigDecimal.valueOf(100)).intValue();
        String paymentReference = HelperFunction.generateUniqueReference();
        PaymentRequest paymentRequest=new PaymentRequest();


        FormPurchase formPurchase=  FormPurchase.builder().purchasedAt(LocalDateTime.now())
                .email(formPurchaseRequest.getApplicantEmail())
                .program(program)
                .amount(amount)
                .status(PaymentStatus.PENDING)
                .paymentReference(paymentReference)
                .build();

        formPurchaseRepository.save(formPurchase);
        paymentService.initializePayment(paymentRequest);
        return null;
    }


    @Override
    public FormPurchase verifyFormPayment(VerifyFormPaymentRequest request) {
        return formPurchaseRepository.findByPaymentReference(request.getEmail(),request.getReferenceCode())
                .orElseThrow();
    }


}
