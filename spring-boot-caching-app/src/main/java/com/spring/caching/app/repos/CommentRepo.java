package com.spring.caching.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.caching.app.entities.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
}
