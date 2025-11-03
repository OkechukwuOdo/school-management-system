package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.StudentApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentApplicantRepository extends MongoRepository<StudentApplication,String> {
//   List<StudentApplication> findAllByStudentMode(String mode);
}
