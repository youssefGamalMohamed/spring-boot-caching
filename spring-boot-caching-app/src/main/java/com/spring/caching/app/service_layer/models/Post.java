package com.spring.caching.app.service_layer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    private Long id;
    private String content;
    private Set<Comment> comments;
}
