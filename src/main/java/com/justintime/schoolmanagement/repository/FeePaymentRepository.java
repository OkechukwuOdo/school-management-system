package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.FeePayment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeePaymentRepository extends MongoRepository<FeePayment, String> {
    FeePayment findFeePaymentByStudentId(String studentId);
}
