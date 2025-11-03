package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Staff;
import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser,String> {
    List<AppUser> findAllByRole(String role);
    Page<AppUser> findAllByRole(String role, Pageable pageable);


    Optional<AppUser> findByEmail(String email);
}
