package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.Review;
import com.justintime.schoolmanagement.model.requestDto.PostRequest;
import com.justintime.schoolmanagement.model.requestDto.ReviewRequest;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.ReviewResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReviewService {
    ReviewResponse uploadReview(ReviewRequest reviewRequest);
    PaginationResponse<ReviewResponse, Review> getAllReview(int offset,int limit);
    ReviewResponse getReviewById(String id);


}
