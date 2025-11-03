package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.Staff;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends MongoRepository<Staff,String> {
    List<Staff> findAllByRole(String string, Pageable pageable);
//    List<Staff> findAllByRole(String string);
}
