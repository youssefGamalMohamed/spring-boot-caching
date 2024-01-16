package com.spring.caching.app.service_layer.implementations;

import com.spring.caching.app.data_layer.core.interfaces.PostRepoInterface;
import com.spring.caching.app.service_layer.interfaces.PostServiceInterface;
import com.spring.caching.app.service_layer.models.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostServiceImpl implements PostServiceInterface {

    @Autowired
    @Qualifier("jpaPostRepoImpl")
    private PostRepoInterface postRepo;

    @Override
    public Long save(Post post) {
        return postRepo.save(post);
    }

    @Cacheable(cacheNames = "POSTS_CACHE" , key = "#postId")
    @Override
    public Post findById(Long postId) {
        log.info(">>>>> FIND BY ID = {}" , postId);
        return postRepo.findById(postId);
    }

    @CacheEvict(cacheNames = "POSTS_CACHE" , key = "#postId")
    @Override
    public void deleteById(Long postId) {
        log.info(">>>>> DELETE BY ID = {}" , postId);
        postRepo.deleteById(postId);
    }
}
