package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.Post;
import com.justintime.schoolmanagement.entity.Review;
import com.justintime.schoolmanagement.entity.enumz.PostType;
import com.justintime.schoolmanagement.exceptions.ResourceNotFoundException;
import com.justintime.schoolmanagement.model.requestDto.PostRequest;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.PostResponseDto;
import com.justintime.schoolmanagement.model.responseDto.ReviewResponse;
import com.justintime.schoolmanagement.repository.PostRepository;
import com.justintime.schoolmanagement.service.PostService;
import com.justintime.schoolmanagement.utilz.objectMapper.PostMapper;
import com.justintime.schoolmanagement.utilz.objectMapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public Post makePost(PostRequest postRequest) {
        return postRepository.save(Post.postInstance(postRequest));

    }

    @Override
    public PaginationResponse<PostResponseDto, Post> getALlBlogs(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Post> page = postRepository.findAllByPostType(PostType.Blog,pageable);
        log.info("all blogs here{}",page.getContent());
        List<PostResponseDto> allBlogs=page.getContent().stream()
                .filter(post -> post.getPostType().equals(PostType.Blog))
                .map(PostMapper::postResponseInstance).toList();
        log.info("all blogs {}",allBlogs);
        return new PaginationResponse<>(allBlogs, page);
    }

    @Override
    public PaginationResponse<PostResponseDto, Post> getALlEvents(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Post> page = postRepository.findAllByPostType(PostType.Event,pageable);
        log.info("all blogs here{}",page.getContent());
        List<PostResponseDto> allBlogs=page.getContent().stream()
                .filter(post -> post.getPostType().equals(PostType.Event))
                .map(PostMapper::postResponseInstance).toList();
        log.info("all blogs {}",allBlogs);
        return new PaginationResponse<>(allBlogs, page);
    }

    @Override
    public String deleteAPost(String id) {
        postRepository.deleteById(id);
        return " Deleted";
    }

    @Override
    public PostResponseDto getABlogById(String id) {
        Post post= postRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException(" Post not fount"));
        return PostMapper.postResponseInstance(post);
    }

    @Override
    public PostResponseDto getAPostById(String id) {
        Post post= postRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException(" Post not fount"));
        return PostMapper.postResponseInstance(post);
    }



    @Override
    public PostResponseDto getEventById(String id) { Post post= postRepository.findById(id)
            .orElseThrow( ()-> new ResourceNotFoundException(" Post not fount"));
        return PostMapper.postResponseInstance(post);
    }

}
