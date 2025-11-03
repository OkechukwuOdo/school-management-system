package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.Program;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.requestDto.ProgramPaymentRequest;
import com.justintime.schoolmanagement.model.requestDto.ProgramRequest;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.ProgramResponseDto;
import com.justintime.schoolmanagement.paymentService.PaymentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProgramService {
    ProgramResponseDto createProgram(ProgramRequest postRequest);

    PaginationResponse<ProgramResponseDto,Program> getAllProgram(int offset,int limit);

    ProgramResponseDto getProgramById(String programId);

    ProgramResponseDto payForAProgram(ProgramPaymentRequest paymentRequest);

//    ProgramResponseDto completeProgramPurchase(PaymentRequest paymentRequest);
//
//    ProgramResponseDto verifyProgramPayment(String email, String registrationPin);

    ProgramResponseDto completeProgramRegistration(ApplicationRequestDto applicationRequestDto);
}
