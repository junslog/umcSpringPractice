package com.umcSpring.week06Assignment.web.controller;

import com.umcSpring.week06Assignment.service.CommentService;
import com.umcSpring.week06Assignment.web.dto.CommentRequestDto.CommentDto;
import com.umcSpring.week06Assignment.web.dto.CommentResponseDto.CommentViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public String writeComment(@RequestBody CommentDto commentDto){
        commentService.writeComment(commentDto.getUserId(),commentDto.getRecipeId(),commentDto.getContent());
        return "success";
    }

    @GetMapping("/comments")
    public List<CommentViewDto> getComments(@RequestParam("recipeId") Long recipeId){
        return commentService.getComments(recipeId);
    }

}
