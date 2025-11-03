package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.FormPurchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FormPurchaseRepository extends MongoRepository<FormPurchase,String> {
//    Optional<FormPurchase> findByPaymentReference(String paymentReference);

    Optional<FormPurchase> findByPaymentReference(String email, String referenceCode);

    Optional<FormPurchase> findByEmail(String email);
}
