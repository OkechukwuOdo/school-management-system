package com.justintime.schoolmanagement.paymentService;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends MongoRepository<PaymentTransaction, Long> {
    Optional<PaymentTransaction> findByReference(String reference);
}
