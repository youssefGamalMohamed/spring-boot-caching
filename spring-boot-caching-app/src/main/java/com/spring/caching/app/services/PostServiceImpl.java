package com.spring.caching.app.services;



import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.caching.app.entities.Post;
import com.spring.caching.app.repos.PostRepo;

@Service
@Slf4j
public class PostServiceImpl implements PostServiceInterface {

    @Autowired
    private PostRepo postRepo;

    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }

    @Cacheable(cacheNames = "POSTS_CACHE" , key = "#postId")
    @Override
    public Post findById(Long postId) {
        log.info(">>>>> FIND BY ID = {}" , postId);
        return postRepo.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("Post not found with id: " + postId));
    }

    @CacheEvict(cacheNames = "POSTS_CACHE" , key = "#postId")
    @Override
    public void deleteById(Long postId) {
        log.info(">>>>> DELETE BY ID = {}" , postId);
        postRepo.deleteById(postId);
    }
}
