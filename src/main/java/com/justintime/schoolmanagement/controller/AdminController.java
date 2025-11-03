package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.SchoolProfile;
import com.justintime.schoolmanagement.model.requestDto.SchoolProfileRequest;
import com.justintime.schoolmanagement.model.requestDto.UserRequest;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    @PostMapping("/updateSchoolProfile")
    public ResponseEntity<ApiResponse<SchoolProfile>> updateSchoolProfile(@RequestBody SchoolProfileRequest schoolProfileRequest){
        SchoolProfile newStaff= adminService.updateSchoolProfile(schoolProfileRequest);
        return ResponseEntity.ok(ApiResponse.createdSuccess(newStaff));
    }
    @GetMapping("/getSchoolProfile")
    public ResponseEntity<ApiResponse<SchoolProfile>> getSchoolProfile(){
        SchoolProfile newStaff= adminService.getSchoolProfile();
        return ResponseEntity.ok(ApiResponse.fetchSuccess(newStaff));
    }

}
