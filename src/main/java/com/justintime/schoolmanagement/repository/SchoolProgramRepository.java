package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Program;
import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolProgramRepository extends MongoRepository<Program,String> {
}
