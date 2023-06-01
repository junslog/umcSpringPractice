package com.umcSpring.week06Assignment.web.dto;

import lombok.*;

public class CommentRequestDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentDto {
        private Long userId;
        private Long recipeId;
        private String content;
    }

}
