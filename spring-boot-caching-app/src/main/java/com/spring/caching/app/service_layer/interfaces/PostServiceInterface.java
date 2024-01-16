package com.spring.caching.app.service_layer.interfaces;


import com.spring.caching.app.service_layer.models.Post;

public interface PostServiceInterface {

    Long save(Post post);

    Post findById(Long postId);

    void deleteById(Long postId);
}
