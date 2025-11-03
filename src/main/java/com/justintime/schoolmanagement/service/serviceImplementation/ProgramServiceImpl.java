package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.Applicants;
import com.justintime.schoolmanagement.entity.FormPurchase;
import com.justintime.schoolmanagement.entity.Program;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.entity.enumz.PaymentStatus;
import com.justintime.schoolmanagement.exceptions.ResourceNotFoundException;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.requestDto.ProgramPaymentRequest;
import com.justintime.schoolmanagement.model.requestDto.ProgramRequest;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.ProgramResponseDto;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import com.justintime.schoolmanagement.paymentService.PaymentRequest;
import com.justintime.schoolmanagement.paymentService.PaystackPaymentService;
import com.justintime.schoolmanagement.paymentService.PaystackUtil;
import com.justintime.schoolmanagement.repository.FormPurchaseRepository;
import com.justintime.schoolmanagement.repository.ProgramRepository;
import com.justintime.schoolmanagement.service.ProgramService;
import com.justintime.schoolmanagement.utilz.objectMapper.ProgramMapper;
import com.justintime.schoolmanagement.utilz.objectMapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;
    private final FormPurchaseRepository formPurchaseRepository;
    private final PaystackPaymentService paystackPaymentService;
    @Override
    public ProgramResponseDto createProgram(ProgramRequest programRequest) {
      Program program=  Program.builder()
              .programType(programRequest.getProgramType())
              .title(programRequest.getTitle())
              .description(programRequest.getDetail())
              .purchasePrice(BigDecimal.valueOf(programRequest.getPurchasePrice()))
              .imageLink(programRequest.getImageLink())
              .build();
        Program newProgram=   programRepository.save(program);
        log.info("new Program {}", newProgram);
        return ProgramMapper.programResponseDtoInstance(newProgram);
    }

    @Override
    public PaginationResponse<ProgramResponseDto,Program> getAllProgram(int offset,int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Program> page = programRepository.findAll(pageable);
        Page<ProgramResponseDto> programResponseDto=  page.map(ProgramMapper::programResponseDtoInstance);
        return new PaginationResponse<>(programResponseDto.getContent(), page);
    }

    @Override
    public ProgramResponseDto getProgramById(String programId) {
        Program program= programRepository.findById(programId).orElseThrow(()->new ResourceNotFoundException("No Program with the id"));
        return ProgramMapper.programResponseDtoInstance(program);
    }

    @Override
    public ProgramResponseDto payForAProgram(ProgramPaymentRequest programPaymentRequest) {
        Program program= programRepository.findById(programPaymentRequest.getProgramId()).orElseThrow(()->new ResourceNotFoundException("No Program with the id"));
        String reference = PaystackUtil.generateReference(program.getId(),programPaymentRequest.getEmail());
        PaymentRequest paymentRequest=
                PaymentRequest.builder()
                        .email(programPaymentRequest.getEmail())
                        .reference(reference)
                        .amount(program.getPurchasePrice().doubleValue())
                        .payment_purpose("Form_purchase")
                        .build();
        FormPurchase formPurchase= FormPurchase.builder()
                .purchasedAt(LocalDateTime.now())
                .paymentReference(reference)
                .email(programPaymentRequest.getEmail())
                .status(PaymentStatus.PENDING)
                .program(program)
                .build();
        formPurchaseRepository.save(formPurchase);
        paystackPaymentService.initializePayment(paymentRequest);
        return null;
    }
//
//    @Override
//    public ProgramResponseDto completeProgramPurchase(PaymentRequest paymentRequest) {
//        return null;
//    }
//
//    @Override
//    public ProgramResponseDto verifyProgramPayment(String email, String registrationPin) {
//        return null;
//    }

    @Override
    public ProgramResponseDto completeProgramRegistration(ApplicationRequestDto applicationRequestDto) {
        formPurchaseRepository.findByEmail(applicationRequestDto.getEmail());
        Program program= Program.builder().build();
        Applicants applicants= Applicants.builder().build();
        StudentApplication.builder()
                .applicants(applicants)
                .program(program)
                .applicationDate(LocalDate.now())
                .build();
//        return "";
        return null;
    }


}
