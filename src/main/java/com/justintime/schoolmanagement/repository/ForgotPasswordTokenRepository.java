package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.PasswordResetToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ForgotPasswordTokenRepository extends MongoRepository<PasswordResetToken, String> {
   Optional<PasswordResetToken> findByToken(String token);

}
