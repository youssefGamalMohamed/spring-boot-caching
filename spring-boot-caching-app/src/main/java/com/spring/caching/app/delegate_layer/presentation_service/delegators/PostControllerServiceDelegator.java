package com.spring.caching.app.delegate_layer.presentation_service.delegators;

import com.spring.caching.app.delegate_layer.presentation_service.mappers.PostMapper;
import com.spring.caching.app.presentation_layer.models.request.SavePostRequestBody;
import com.spring.caching.app.presentation_layer.models.response.SavePostResponseBody;
import com.spring.caching.app.service_layer.interfaces.PostServiceInterface;
import com.spring.caching.app.service_layer.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostControllerServiceDelegator {


    @Autowired
    private PostServiceInterface postService;

    public SavePostResponseBody save(SavePostRequestBody requestBody) {
        Post post = PostMapper.toServiceModel(requestBody);
        Long newPostId = postService.save(post);
        return SavePostResponseBody.builder()
                .id(newPostId)
                .build();
    }
}
