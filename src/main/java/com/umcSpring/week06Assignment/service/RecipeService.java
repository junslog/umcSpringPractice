package com.umcSpring.week06Assignment.service;

import com.umcSpring.week06Assignment.web.dto.RecipeResponseDto;
import com.umcSpring.week06Assignment.web.dto.RecipeResponseDto.RecipeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {

    Page<RecipeResponseDto.RecipeDto> getRecipeList(Pageable pageable, int cursor);

    RecipeResponseDto.RecipeLikeDto likeRecipe(Long userId, Long recipeId);

}
