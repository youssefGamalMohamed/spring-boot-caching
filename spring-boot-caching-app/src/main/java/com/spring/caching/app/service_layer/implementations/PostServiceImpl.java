package com.spring.caching.app.service_layer.implementations;

import com.spring.caching.app.data_layer.core.interfaces.PostRepoInterface;
import com.spring.caching.app.service_layer.interfaces.PostServiceInterface;
import com.spring.caching.app.service_layer.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostServiceInterface {

    @Autowired
    @Qualifier("jpaPostRepoImpl")
    private PostRepoInterface postRepo;

    @Override
    public Long save(Post post) {
        return postRepo.save(post);
    }
}
