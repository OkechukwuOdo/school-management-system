package com.justintime.schoolmanagement.service;

import com.justintime.schoolmanagement.entity.Post;
import com.justintime.schoolmanagement.model.requestDto.PostRequest;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.PostResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    Post makePost(PostRequest postRequest);

    PaginationResponse<PostResponseDto, Post> getALlBlogs(int offset,int limit);

    PaginationResponse<PostResponseDto, Post> getALlEvents(int offset,int limit);

    String deleteAPost(String id);

    PostResponseDto getABlogById(String id);


    PostResponseDto getEventById(String id);
    PostResponseDto getAPostById(String id);
}
