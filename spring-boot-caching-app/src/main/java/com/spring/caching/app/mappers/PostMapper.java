package com.spring.caching.app.mappers;


import com.spring.caching.app.entities.Post;
import com.spring.caching.app.models.PostDto;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface PostMapper {
    PostDto toDto(Post post);
    Post toEntity(PostDto postDto);
    List<PostDto> toDtoList(List<Post> posts);
}
