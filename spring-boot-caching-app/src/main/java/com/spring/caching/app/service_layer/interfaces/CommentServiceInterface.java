package com.spring.caching.app.service_layer.interfaces;

import com.spring.caching.app.service_layer.models.Comment;

public interface CommentServiceInterface {
    Long save(Comment comment);
}
