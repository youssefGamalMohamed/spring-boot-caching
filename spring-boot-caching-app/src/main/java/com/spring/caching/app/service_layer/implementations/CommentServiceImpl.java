package com.spring.caching.app.service_layer.implementations;

import com.spring.caching.app.service_layer.interfaces.CommentServiceInterface;
import com.spring.caching.app.service_layer.models.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentServiceInterface {
    @Override
    public Long save(Comment comment) {
        return null;
    }
}
