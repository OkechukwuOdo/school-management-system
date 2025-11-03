package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review,String> {
}
