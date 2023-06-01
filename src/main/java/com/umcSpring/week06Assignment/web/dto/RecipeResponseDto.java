package com.umcSpring.week06Assignment.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class RecipeResponseDto{

    public interface RecipeDto {

        LocalDateTime getCreatedAt();
        Long getUserId();
        Integer getLikes();
    }

    public static class RecipeDto {

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeLikeDto{
        String message;
    }

}

