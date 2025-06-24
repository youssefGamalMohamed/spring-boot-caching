package com.spring.caching.app.controllers;

import com.spring.caching.app.models.PostDto;
import com.spring.caching.app.services.PostServiceInterface;
import com.spring.caching.app.mappers.PostMapper;
import com.spring.caching.app.entities.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostServiceInterface postService;

    @Autowired
    private PostMapper postMapper;

    @PostMapping
    public ResponseEntity<PostDto> save(@RequestBody PostDto requestBody) {
        log.info(">>>>> REQUEST = {}", requestBody);
        Post post = postMapper.toEntity(requestBody);
        Post saved = postService.save(post);
        PostDto responseBody = postMapper.toDto(saved);
        log.info(">>>>> RESPONSE = {}", responseBody);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable(name = "id") Long postId) {
        Post post = postService.findById(postId);
        PostDto responseBody = postMapper.toDto(post);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long postId) {
        postService.deleteById(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}