package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.SchoolProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<SchoolProfile,String> {
}
