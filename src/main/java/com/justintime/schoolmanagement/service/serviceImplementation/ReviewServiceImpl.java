package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Review;
import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import com.justintime.schoolmanagement.exceptions.ResourceNotFoundException;
import com.justintime.schoolmanagement.model.requestDto.PostRequest;
import com.justintime.schoolmanagement.model.requestDto.ReviewRequest;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.ReviewResponse;
import com.justintime.schoolmanagement.repository.ReviewRepository;
import com.justintime.schoolmanagement.service.ReviewService;
import com.justintime.schoolmanagement.utilz.objectMapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    @Override
    public ReviewResponse uploadReview(ReviewRequest reviewRequest) {
        Review review= Review.reviewInstance(reviewRequest);
        log.info("review {}",review);
        Review newReview=reviewRepository.save(review);
        return ReviewMapper.reviewResponseInstance(newReview);
    }

    @Override
    public PaginationResponse<ReviewResponse, Review> getAllReview(int offset,int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Review> page = reviewRepository.findAll(pageable);
        List<ReviewResponse> allReview=page.getContent().stream()
                .map(ReviewMapper::reviewResponseInstance).toList();
        return new PaginationResponse<>(allReview, page);
    }

    @Override
    public ReviewResponse getReviewById(String id) {
        Review review= reviewRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Review Does not exist"));
        return ReviewMapper.reviewResponseInstance(review);
    }
}
