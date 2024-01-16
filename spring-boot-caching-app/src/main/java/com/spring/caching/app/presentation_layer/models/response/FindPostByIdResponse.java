package com.spring.caching.app.presentation_layer.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindPostByIdResponse {

    private Long id;
    private String content;

}
