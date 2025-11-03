package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Staff;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import com.justintime.schoolmanagement.service.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/user/staff")
public class StaffController {
    private final StaffService staffService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<StaffResponseDto>> registerStaff(@RequestBody StaffRequestDto staffRequestDto){
      StaffResponseDto newStaff= staffService.createStaff(staffRequestDto);
        return ResponseEntity.ok(ApiResponse.createdSuccess(newStaff));
    }
    @GetMapping("/getAllStaffByType")
    public ResponseEntity<ApiResponse<PaginationResponse<StaffResponseDto, Staff>>> getAllStaffByType(
            @RequestParam(value = "staffType") String staffType,
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit

    ){
        log.info("Staff type {}",staffType);
        return ResponseEntity.ok(ApiResponse.buildSuccessTxn(staffService.getALlStaffByType(staffType,offset,limit)));
    }
    @GetMapping("/getAllStaff")
    public ResponseEntity<ApiResponse<PaginationResponse<StaffResponseDto, Staff>>> getAllStaff(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit
    ){
        return ResponseEntity.ok(ApiResponse.buildSuccessTxn(staffService.getAllStaff(limit,offset)));
    }
    @GetMapping("/getStaffById/{id}")
    public ResponseEntity<?> getStaffById(@PathVariable String id){
        return ResponseEntity.ok(staffService.getAStaffById(id));
    }
    @DeleteMapping("/deleteStaff/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStaff(@PathVariable String id){
        return ResponseEntity.ok(ApiResponse.deleteResponse(staffService.deleteAStaff(id)));
}}
