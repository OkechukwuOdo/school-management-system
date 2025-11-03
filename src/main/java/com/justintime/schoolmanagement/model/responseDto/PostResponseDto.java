package com.justintime.schoolmanagement.model.responseDto;

import com.justintime.schoolmanagement.entity.enumz.PostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponseDto {
    private String id;
    private String imageLink;
    private String title;
    private String description;
    private PostType postType;
}
