package com.spring.caching.app.data_layer.jpa.mappers;

import com.spring.caching.app.data_layer.jpa.entities.JpaPostEntity;
import com.spring.caching.app.service_layer.models.Post;
import org.springframework.util.Assert;

public class JpaPostMapper {

    public static JpaPostEntity fromServiceModelToJpaEntity(Post post) {
        Assert.notNull(post, "Post Must Not Be Null");
        return JpaPostEntity.builder()
                .id(post.getId())
                .content(post.getContent())
                .build();
    }
}
