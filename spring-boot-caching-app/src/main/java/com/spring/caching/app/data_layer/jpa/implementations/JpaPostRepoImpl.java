package com.spring.caching.app.data_layer.jpa.implementations;

import com.spring.caching.app.data_layer.core.interfaces.PostRepoInterface;
import com.spring.caching.app.data_layer.jpa.entities.JpaPostEntity;
import com.spring.caching.app.data_layer.jpa.mappers.JpaPostMapper;
import com.spring.caching.app.data_layer.jpa.repositiories.JpaPostRepo;
import com.spring.caching.app.service_layer.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPostRepoImpl implements PostRepoInterface {

    @Autowired
    @Lazy
    private JpaPostRepo jpaPostRepo;

    @Override
    public Long save(Post post) {
        JpaPostEntity entity = JpaPostMapper.fromServiceModelToJpaEntity(post);
        entity = jpaPostRepo.save(entity);
        return entity.getId();
    }

    @Override
    public Post findById(Long postId) {
        JpaPostEntity postEntity = jpaPostRepo.findById(postId)
                .orElseThrow();
        return JpaPostMapper.fromJpaEntityToServiceModel(postEntity);
    }

    @Override
    public void deleteById(Long postId) {
        jpaPostRepo.deleteById(postId);
    }
}
