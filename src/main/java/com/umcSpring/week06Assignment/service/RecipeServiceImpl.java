package com.umcSpring.week06Assignment.service;

import com.umcSpring.week06Assignment.domain.Recipe;
import com.umcSpring.week06Assignment.domain.User;
import com.umcSpring.week06Assignment.domain.UserRecipeLike;
import com.umcSpring.week06Assignment.repository.RecipeRepository;
import com.umcSpring.week06Assignment.repository.UserRecipeLikeRepository;
import com.umcSpring.week06Assignment.repository.UserRepository;
import com.umcSpring.week06Assignment.web.dto.RecipeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRecipeLikeRepository userRecipeLikeRepository;

    private final UserRepository userRepository;

    @Override
    public Page<RecipeResponseDto.RecipeDto> getRecipeList(Pageable pageable, final int cursor) {

        Pageable pageableFinal = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort(), )
        // Pagination 구현해야할 곳
        Page<RecipeResponseDto.RecipeDto> RecipeDtoList = recipeRepository.findRecipeList(pageable);
        return RecipeDtoList;
    }
    @Override
    @Transactional
    public RecipeResponseDto.RecipeLikeDto likeRecipe(Long userId, Long recipeId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저 아이디를 통해 user 객체 조회")
        );
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 레시피 아이디를 통해 recipe 객체 조회")
        );
        Optional<UserRecipeLike> userRecipeLikeOptional
                = userRecipeLikeRepository.findByUserAndRecipe(user, recipe);

        if( userRecipeLikeOptional.isPresent() ){
            // 좋아요 삭제
            userRecipeLikeRepository.deleteByUserAndRecipe(user, recipe);
            RecipeResponseDto.RecipeLikeDto recipeLikeDto = new RecipeResponseDto.RecipeLikeDto("좋아요 취소");
            return recipeLikeDto;
        } else {
            // 좋아요 추가
            UserRecipeLike userRecipeLike = new UserRecipeLike(user, recipe);
            userRecipeLikeRepository.save(userRecipeLike);
            RecipeResponseDto.RecipeLikeDto recipeLikeDto = new RecipeResponseDto.RecipeLikeDto("좋아요 완료");
            return recipeLikeDto;
        }

    }
}
