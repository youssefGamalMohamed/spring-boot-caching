package com.spring.caching.app.services;

import com.spring.caching.app.entities.Post;

public interface PostServiceInterface {

    Post save(Post post);

    Post findById(Long postId);

    void deleteById(Long postId);
}
