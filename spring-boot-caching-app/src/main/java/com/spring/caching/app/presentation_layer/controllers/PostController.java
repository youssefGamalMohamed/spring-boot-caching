package com.spring.caching.app.presentation_layer.controllers;

import com.spring.caching.app.data_layer.jpa.repositiories.JpaPostRepo;
import com.spring.caching.app.delegate_layer.presentation_service.delegators.PostControllerServiceDelegator;
import com.spring.caching.app.presentation_layer.models.request.SavePostRequestBody;
import com.spring.caching.app.presentation_layer.models.response.FindPostByIdResponse;
import com.spring.caching.app.presentation_layer.models.response.SavePostResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PostController {
    @Autowired
    private JpaPostRepo jpaPostRepo;


    @Autowired
    private PostControllerServiceDelegator postControllerServiceDelegator;

    @PostMapping("/posts")
    public ResponseEntity<?> save(@RequestBody SavePostRequestBody requestBody) {
        log.info(">>>>> REQUEST = {}" , requestBody);

        SavePostResponseBody responseBody = postControllerServiceDelegator.save(requestBody);

        log.info(">>>>> RESPONSE = {}" , responseBody);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long postId) {
        FindPostByIdResponse responseBody = postControllerServiceDelegator.findById(postId);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long postId) {
        postControllerServiceDelegator.deleteById(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
