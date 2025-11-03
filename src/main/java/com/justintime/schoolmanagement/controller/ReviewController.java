package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.Review;
import com.justintime.schoolmanagement.model.requestDto.PostRequest;
import com.justintime.schoolmanagement.model.requestDto.ReviewRequest;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.ReviewResponse;
import com.justintime.schoolmanagement.service.PostService;
import com.justintime.schoolmanagement.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;
    @PostMapping("/uploadReview")
    public ResponseEntity<ReviewResponse> uploadReview(@RequestBody ReviewRequest reviewRequest){
        return ResponseEntity.ok(reviewService.uploadReview(reviewRequest));
    }
    @GetMapping("/getAllReview")
    public ResponseEntity<ApiResponse<PaginationResponse<ReviewResponse, Review>>> getAllReview(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                                                                                @RequestParam(value = "limit", defaultValue = "5") int limit){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(reviewService.getAllReview(offset,limit)));
    }

    @GetMapping("/getReviewById/{id}")
    public ResponseEntity<ApiResponse<?>> getReviewById(@PathVariable String id){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(reviewService.getReviewById(id)));
    }
}
