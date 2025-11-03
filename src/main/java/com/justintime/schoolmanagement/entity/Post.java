package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.entity.enumz.PostType;
import com.justintime.schoolmanagement.model.requestDto.PostRequest;
import com.justintime.schoolmanagement.model.responseDto.PostResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Post {
    private String id;
    private String imageLink;
    private String title;
    private String description;
    private PostType postType;

    private Post(PostRequest postRequest){
        imageLink=postRequest.getImageLink();
        title=postRequest.getTitle();
        description=postRequest.getDescription();
        postType=postRequest.getPostType();
    }
    public static Post postInstance(PostRequest postRequest){
        return new Post(postRequest);
    }
}
