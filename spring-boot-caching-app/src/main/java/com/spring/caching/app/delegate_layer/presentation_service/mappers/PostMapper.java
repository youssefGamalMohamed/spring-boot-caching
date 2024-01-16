package com.spring.caching.app.delegate_layer.presentation_service.mappers;

import com.spring.caching.app.presentation_layer.models.request.SavePostRequestBody;
import com.spring.caching.app.presentation_layer.models.response.FindPostByIdResponse;
import com.spring.caching.app.service_layer.models.Post;

public class PostMapper {

    public static Post toServiceModel(SavePostRequestBody requestBody) {
        return Post.builder()
                .content(requestBody.getContent())
                .build();
    }


    public static FindPostByIdResponse toResponse(Post post) {
        return FindPostByIdResponse.builder()
                .id(post.getId())
                .content(post.getContent())
                .build();
    }
}
