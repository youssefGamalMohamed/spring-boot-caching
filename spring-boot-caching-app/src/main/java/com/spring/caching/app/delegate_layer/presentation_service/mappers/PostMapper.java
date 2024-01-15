package com.spring.caching.app.delegate_layer.presentation_service.mappers;

import com.spring.caching.app.presentation_layer.models.request.SavePostRequestBody;
import com.spring.caching.app.service_layer.models.Post;

public class PostMapper {

    public static Post toServiceModel(SavePostRequestBody requestBody) {
        return Post.builder()
                .content(requestBody.getContent())
                .build();
    }
}
