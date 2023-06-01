package com.umcSpring.week06Assignment.web.dto;

import lombok.Getter;

public class RecipeRequestDto {
    @Getter
    public static class RecipeLikeDto{
        Long userId;
    }
}
