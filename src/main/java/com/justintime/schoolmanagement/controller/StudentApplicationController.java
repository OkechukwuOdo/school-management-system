package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.Applicants;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import com.justintime.schoolmanagement.service.StudentApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/applicant/student")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<StudentApplicationResponseDto>> applicationRegistration(@RequestBody ApplicationRequestDto studentRequestDto){
        log.info("Program id {}",studentRequestDto);
        log.info("Programs  {}",studentRequestDto.getProgramId());
        return ResponseEntity.ok(ApiResponse.createdSuccess(studentApplicationService.applicationRegistration(studentRequestDto)));
    }

    @GetMapping("/getAllApplicants")
    public ResponseEntity<ApiResponse<PaginationResponse<StudentApplicationResponseDto, StudentApplication>>> getAllApplication(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit
    ){
        log.info("Executing getAllApplicants");
        return ResponseEntity.ok(ApiResponse.buildSuccessTxn(studentApplicationService.getAllApplication(offset,limit)));
    }
    @GetMapping("/getApplicantById/{id}")
    public ResponseEntity<ApiResponse<StudentApplicationResponseDto>> getApplicantById (@PathVariable String id){
        return ResponseEntity.ok(ApiResponse.createdSuccess(studentApplicationService.getApplicantById(id)));
}

}
