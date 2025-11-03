package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.Post;
import com.justintime.schoolmanagement.entity.Program;
import com.justintime.schoolmanagement.entity.Review;
import com.justintime.schoolmanagement.entity.SchoolProfile;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.requestDto.FormPurchaseRequest;
import com.justintime.schoolmanagement.model.requestDto.ProgramPaymentRequest;
import com.justintime.schoolmanagement.model.requestDto.VerifyFormPaymentRequest;
import com.justintime.schoolmanagement.model.responseDto.*;
import com.justintime.schoolmanagement.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/web-content")
@Slf4j
public class WebSiteController {
    private final WebBaseServices webBaseServices;

    private final PostService postService;
    private final ProgramService programService;
    private final ReviewService reviewService;
    private final AdminService adminService;


    @GetMapping("/getAllPrograms")
    public ResponseEntity<ApiResponse<PaginationResponse<ProgramResponseDto, Program>>> getAllPrograms(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit
    ){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(programService.getAllProgram(limit,offset)));
    }

    @GetMapping("/getProgramsById/{id}")
    public ResponseEntity<ApiResponse<?>> getProgramsById(@PathVariable String id){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(programService.getProgramById(id)));
    }
    @GetMapping("/getAllEvents")
    public ResponseEntity<ApiResponse<PaginationResponse<PostResponseDto, Post>>> getAllEvents(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getALlEvents(limit,offset)));
    }

    @GetMapping("/getEventById/{id}")
    public ResponseEntity<ApiResponse<?>> getEventById(@PathVariable String id){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getEventById(id)));
    }

    @GetMapping("/getAllReview")
    public ResponseEntity<ApiResponse<PaginationResponse<ReviewResponse, Review>>> getAllReview(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(reviewService.getAllReview(limit,offset)));
    }

    @GetMapping("/getReviewById/{id}")
    public ResponseEntity<ApiResponse<?>> getReviewById(@PathVariable String id){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(reviewService.getReviewById(id)));
    }
    @GetMapping("/getALlBlogs")
    public ResponseEntity<ApiResponse<PaginationResponse<PostResponseDto, Post>>> getALlBlogs( @RequestParam(value = "offset", defaultValue = "0") int offset,
                                                                                               @RequestParam(value = "limit", defaultValue = "5") int limit){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getALlBlogs(offset,limit)));
    }

    @GetMapping("/getABlogById/{id}")
    public ResponseEntity<ApiResponse<?>> getABlogById(@PathVariable String id){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getABlogById(id)));
    }

    @GetMapping("/getAPostById/{id}")
    public ResponseEntity<ApiResponse<?>> getAPostById(@PathVariable String id){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getAPostById(id)));
    }
    @GetMapping("/getSchoolProfile")
    public ResponseEntity<ApiResponse<SchoolProfile>> getSchoolProfile(){
        SchoolProfile newStaff= adminService.getSchoolProfile();
        return ResponseEntity.ok(ApiResponse.fetchSuccess(newStaff));
    }

    @PutMapping("/completeProgramRegistration")
public ResponseEntity<ProgramResponseDto> completeProgramRegistration( @RequestBody ApplicationRequestDto applicationRequestDto){
    return ResponseEntity.ok(programService.completeProgramRegistration(applicationRequestDto));
}
}
