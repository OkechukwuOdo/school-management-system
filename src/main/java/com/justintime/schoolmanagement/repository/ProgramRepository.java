package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgramRepository extends MongoRepository<Program,String> {
}
