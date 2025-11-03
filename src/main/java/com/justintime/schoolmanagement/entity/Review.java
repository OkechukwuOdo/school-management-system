package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.enumz.PostType;
import com.justintime.schoolmanagement.model.requestDto.ReviewRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "review")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Review {
    @Id
    private String id;
    private String imageLink;
    private String nameOfReviewer;
    private String review;
    private LocalDate createdAt;
    private Review(ReviewRequest reviewRequest){
        imageLink=reviewRequest.getImageLink();
        nameOfReviewer=reviewRequest.getNameOfReviewer();
        review=reviewRequest.getReview();
    }
    public static  Review reviewInstance(ReviewRequest reviewRequest){
        return new Review(reviewRequest);
    }
}
