package com.spring.caching.app.data_layer.jpa.repositiories;

import com.spring.caching.app.data_layer.jpa.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
}
