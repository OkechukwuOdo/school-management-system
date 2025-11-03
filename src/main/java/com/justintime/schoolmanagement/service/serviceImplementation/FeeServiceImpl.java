package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.FeePayment;
import com.justintime.schoolmanagement.entity.FeeType;
import com.justintime.schoolmanagement.entity.Student;
import com.justintime.schoolmanagement.entity.enumz.FeeStatus;
import com.justintime.schoolmanagement.model.requestDto.FeePaymentRequest;
import com.justintime.schoolmanagement.model.requestDto.FeeTypeRequest;
import com.justintime.schoolmanagement.paymentService.PaymentRequest;
import com.justintime.schoolmanagement.paymentService.PaymentTransaction;
import com.justintime.schoolmanagement.paymentService.PaystackPaymentService;
import com.justintime.schoolmanagement.paymentService.PaystackUtil;
import com.justintime.schoolmanagement.repository.AppUserRepository;
import com.justintime.schoolmanagement.repository.FeePaymentRepository;
import com.justintime.schoolmanagement.repository.FeeTypeRepository;
import com.justintime.schoolmanagement.service.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeeServiceImpl implements FeeService {
    private final AppUserRepository appUserRepository;
    private final FeeTypeRepository feeTypeRepository;
    private final FeePaymentRepository feePaymentRepository;
    private final PaystackPaymentService paystackPaymentService;
    BigDecimal amount= BigDecimal.valueOf(0);

    @Override
    public Object makePayment(FeePaymentRequest payment) {
        Student student= (Student) appUserRepository.findById(payment.getStudentId()).orElseThrow();
        FeeType feeType= feeTypeRepository.findFeeTypesByLevel(student.getSchoolCategory().toString(),45);
        FeePayment feePayment= feePaymentRepository.findFeePaymentByStudentId(student.getId());
        if(feePayment==null){
            if(Objects.equals(payment.getAmount(), "FULL_PAYMENT")){
                amount= BigDecimal.valueOf(feeType.getAmount());
            }else {
                 amount= BigDecimal.valueOf(feeType.getAmount()/2);
            }
            FeePayment newFeePayment= new FeePayment();
//            newFeePayment.setStudentId(student.getId());
//            newFeePayment.setStatus(FeeStatus.UNPAID);

        }
        PaymentRequest paymentRequest= new PaymentRequest();
        paymentRequest.setPayment_purpose(feeType.getName());
        paymentRequest.setEmail(student.getEmail());
        paymentRequest.setAmount(amount.doubleValue());
        paystackPaymentService.initializePayment(paymentRequest);
        return null;
    }

    @Override
    public FeeType createFeeType(FeeTypeRequest feeType) {
        return null;
    }

    @Override
    public List<FeePayment> getPaymentsByStudent(String studentId) {
        return List.of();
    }

    @Override
    public Double getOutstandingBalance(String studentId, String feeTypeId) {
        return 0.0;
    }

    public void updateFeePayment(String id){
        FeePayment feePayment =new FeePayment();
        Student student= (Student) appUserRepository.findById(id).orElseThrow();
        feePayment= feePaymentRepository.findFeePaymentByStudentId(student.getId());
        FeeType feeType= feeTypeRepository.findFeeTypesByIdIs("");

    }
}
