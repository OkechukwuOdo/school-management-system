package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.FeeType;
import com.justintime.schoolmanagement.entity.enumz.SchoolCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FeeTypeRepository extends MongoRepository<FeeType,String> {
//   Optional<FeeType> findBySchoolCategoryAndLevelAndFeeType(SchoolCategory schoolCategory, String level, String feeType);

   FeeType findFeeTypesByLevel(String level, Integer term);

   FeeType findFeeTypesByIdIs(String id);
}
