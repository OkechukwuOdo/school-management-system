package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.Program;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.requestDto.ProgramPaymentRequest;
import com.justintime.schoolmanagement.model.requestDto.ProgramRequest;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.ProgramResponseDto;
import com.justintime.schoolmanagement.paymentService.PaymentRequest;
import com.justintime.schoolmanagement.service.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/program")
public class ProgramController {
    private final ProgramService programService;
    @PostMapping("/createProgram")
    public ResponseEntity<ProgramResponseDto> uploadProgram(@RequestBody ProgramRequest postRequest){
        return ResponseEntity.ok(programService.createProgram(postRequest));
    }
    @GetMapping("/getAllProgram")
    public ResponseEntity<ApiResponse<PaginationResponse<ProgramResponseDto,Program>>> getAllProgram(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit
    ){
        return ResponseEntity.ok(ApiResponse.buildSuccessTxn(programService.getAllProgram(offset,limit)));
    }
    @GetMapping("/getProgramById/{programId}")
    public ResponseEntity<ApiResponse<ProgramResponseDto>> getProgramById(@PathVariable String programId){
        return ResponseEntity.ok(ApiResponse.buildSuccessTxn(programService.getProgramById(programId)));
    }
    @PostMapping("/payForAProgram")
    public ResponseEntity<ProgramResponseDto> payForAProgram(@RequestBody ProgramPaymentRequest request){
        return ResponseEntity.ok(programService.payForAProgram(request));
    }
//    @PostMapping("/completeProgramPurchase")
//    public ResponseEntity<ProgramResponseDto> completeProgramPurchase(@RequestBody PaymentRequest paymentRequest){
//        return ResponseEntity.ok(programService.completeProgramPurchase(paymentRequest));
//    }
//    @PostMapping("/verifyProgramPayment")
//    public ResponseEntity<ProgramResponseDto> verifyProgramPayment( String email,String registrationPin){
//        return ResponseEntity.ok(programService.verifyProgramPayment(email,registrationPin));
//    }

    @PutMapping("/completeProgramRegistration")
    public ResponseEntity<ProgramResponseDto> completeProgramRegistration( @RequestBody ApplicationRequestDto applicationRequestDto){
        return ResponseEntity.ok(programService.completeProgramRegistration(applicationRequestDto));
    }
}
