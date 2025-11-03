package com.justintime.schoolmanagement.repository;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Post;
import com.justintime.schoolmanagement.entity.enumz.PostType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    Page<Post> findAllByPostType(PostType postType, Pageable pageable);
}
