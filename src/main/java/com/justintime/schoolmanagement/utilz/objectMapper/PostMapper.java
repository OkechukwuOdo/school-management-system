package com.justintime.schoolmanagement.utilz.objectMapper;

import com.justintime.schoolmanagement.entity.Post;
import com.justintime.schoolmanagement.model.responseDto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostMapper {
    public static PostResponseDto postResponseInstance(Post post){
        return PostResponseDto.builder()
                .id(post.getId())
                .description(post.getDescription())
                .title(post.getTitle())
                .postType(post.getPostType())
                .imageLink(post.getImageLink())
                .build();
    }
}
