package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Page<AppUser> findAllByRole(Pageable pageable);
}
