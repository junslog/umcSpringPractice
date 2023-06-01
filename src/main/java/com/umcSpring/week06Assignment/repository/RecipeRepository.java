package com.umcSpring.week06Assignment.repository;

import com.umcSpring.week06Assignment.domain.Recipe;
import com.umcSpring.week06Assignment.web.dto.RecipeResponseDto;
import com.umcSpring.week06Assignment.web.dto.RecipeResponseDto.RecipeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query(value = "select r.createdAt as createdAt, " +
            "r.user.userId as userId, " +
            "r.likes as likes " +
            "from Recipe r join User u")
    List<RecipeResponseDto.RecipeDto> findRecipeList();

    Page<RecipeResponseDto.RecipeDto> findRecipeList(Pageable pageable);

}
