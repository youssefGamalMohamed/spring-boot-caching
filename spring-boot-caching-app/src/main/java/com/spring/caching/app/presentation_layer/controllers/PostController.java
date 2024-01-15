package com.spring.caching.app.presentation_layer.controllers;

import com.spring.caching.app.delegate_layer.presentation_service.delegators.PostControllerServiceDelegator;
import com.spring.caching.app.presentation_layer.models.request.SavePostRequestBody;
import com.spring.caching.app.presentation_layer.models.response.SavePostResponseBody;
import com.spring.caching.app.service_layer.interfaces.PostServiceInterface;
import com.spring.caching.app.service_layer.models.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PostController {


    @Autowired
    private PostControllerServiceDelegator postControllerServiceDelegator;

    @PostMapping("/posts")
    public ResponseEntity<?> save(@RequestBody SavePostRequestBody requestBody) {
        log.info(">>>>> REQUEST = {}" , requestBody);

        SavePostResponseBody responseBody = postControllerServiceDelegator.save(requestBody);

        log.info(">>>>> RESPONSE = {}" , responseBody);
        return ResponseEntity.ok(responseBody);
    }
}
