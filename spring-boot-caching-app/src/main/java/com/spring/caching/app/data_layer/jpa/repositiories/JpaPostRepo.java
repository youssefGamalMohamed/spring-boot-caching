package com.spring.caching.app.data_layer.jpa.repositiories;

import com.spring.caching.app.data_layer.core.interfaces.PostRepoInterface;
import com.spring.caching.app.data_layer.jpa.entities.JpaPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostRepo extends JpaRepository<JpaPostEntity,Long> {
}
