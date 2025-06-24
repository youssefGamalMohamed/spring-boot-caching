package com.spring.caching.app.mappers;

import com.spring.caching.app.entities.Comment;
import com.spring.caching.app.models.CommentDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDto(Comment comment);
    Comment toEntity(CommentDto commentDto);
}