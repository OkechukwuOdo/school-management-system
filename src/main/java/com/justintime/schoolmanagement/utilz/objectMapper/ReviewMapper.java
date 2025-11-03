package com.justintime.schoolmanagement.utilz.objectMapper;

import com.justintime.schoolmanagement.entity.Review;
import com.justintime.schoolmanagement.model.responseDto.ReviewResponse;

public class ReviewMapper {
    public static ReviewResponse reviewResponseInstance(Review review){
        return ReviewResponse.builder().build();
    }
}
