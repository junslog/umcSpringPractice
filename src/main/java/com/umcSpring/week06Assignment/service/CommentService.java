package com.umcSpring.week06Assignment.service;

import com.umcSpring.week06Assignment.web.dto.CommentResponseDto;
import com.umcSpring.week06Assignment.web.dto.CommentResponseDto.CommentViewDto;

import java.util.List;

public interface CommentService {
    void writeComment(Long userId, Long recipeId, String content);
    List<CommentResponseDto.CommentViewDto> getComments(Long recipeId);
}
