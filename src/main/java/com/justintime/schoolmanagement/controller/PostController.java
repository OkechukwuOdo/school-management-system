package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.Post;
import com.justintime.schoolmanagement.model.requestDto.PostRequest;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.PostResponseDto;
import com.justintime.schoolmanagement.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/post")
public class PostController {
    private final PostService postService;
    @PostMapping("/uploadPost")
    public ResponseEntity<?> uploadPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.makePost(postRequest));
    }

//    @GetMapping("/getEventById/{id}")
//    public ResponseEntity<ApiResponse<?>> getEventById(@PathVariable String id){
//        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getEventById(id)));
//    }

    @DeleteMapping("/deletePost")
    public ResponseEntity<?> deletePost(String id){
        return ResponseEntity.ok(postService.deleteAPost(id));
    }
    @GetMapping("/getALlBlogs")
    public ResponseEntity<ApiResponse<PaginationResponse<PostResponseDto, Post>>> getALlBlogs(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getALlBlogs(offset,limit)));
    }
    @GetMapping("/getAllEvents")
    public ResponseEntity<ApiResponse<PaginationResponse<PostResponseDto, Post>>> getAllEvents(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getALlEvents(offset,limit)));
    }

//    @GetMapping("/getABlogById/{id}")
//    public ResponseEntity<ApiResponse<?>> getABlogById(@PathVariable String id){
//        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getABlogById(id)));
//    }

    @GetMapping("/getAPostById/{id}")
    public ResponseEntity<ApiResponse<?>> getAPostById(@PathVariable String id){
        return  ResponseEntity.ok(ApiResponse.buildSuccessTxn(postService.getAPostById(id)));
    }

}
