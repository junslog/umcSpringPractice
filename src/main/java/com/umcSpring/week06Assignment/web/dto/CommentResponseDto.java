package com.umcSpring.week06Assignment.web.dto;

import lombok.*;

import java.time.LocalDateTime;

public class CommentResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentViewDto {
        public String nickname;
        public String content;

        public LocalDateTime createdAt;
    }

}
