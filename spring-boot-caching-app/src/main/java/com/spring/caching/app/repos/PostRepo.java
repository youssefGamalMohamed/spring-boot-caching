package com.spring.caching.app.repos;

import com.spring.caching.app.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
