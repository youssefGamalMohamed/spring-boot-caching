package com.spring.caching.app.data_layer.core.interfaces;


import com.spring.caching.app.service_layer.models.Post;

public interface PostRepoInterface {
    Long save(Post post);

    Post findById(Long postId);

    void deleteById(Long postId);
}
