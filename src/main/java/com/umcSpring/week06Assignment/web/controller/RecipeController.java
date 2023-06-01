package com.umcSpring.week06Assignment.web.controller;

import com.umcSpring.week06Assignment.service.RecipeService;
import com.umcSpring.week06Assignment.web.dto.RecipeRequestDto;
import com.umcSpring.week06Assignment.web.dto.RecipeResponseDto;
import com.umcSpring.week06Assignment.web.dto.RecipeResponseDto.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    // 레시피 목록에는, 상세정보가 아닌, 작성날짜, 작성자, 좋아요 갯수만 보이게
    /*@GetMapping("/recipes")
    public ResponseEntity<List<RecipeResponseDto.RecipeDto>> getRecipeList(@RequestParam("page") int page){
        List<RecipeResponseDto.RecipeDto> recipeListDto = recipeService.getRecipeList();
        return ResponseEntity.ok(recipeListDto);
    }*/


    // [ 레시피 목록 조회 API → 최신순 10개 페이징 ]
    // Query String의 값으로, current item 값을 가져온다.
    @GetMapping("/recipes")
    public ResponseEntity<Page<RecipeDto>> getRecipeList(
            @RequestParam(value = "last", defaultValue = "0") int last,
            @PageableDefault(size=10, sort="createdAt", direction = Sort.Direction.DESC) Pageable pageable){

        return ResponseEntity.ok(recipeService.getRecipeList(pageable, last));
    }

    @PostMapping("/recipes/{recipeId}/like")
    public ResponseEntity<RecipeResponseDto.RecipeLikeDto> likeRecipe(@RequestBody RecipeRequestDto.RecipeLikeDto recipeLikeRequestDto, @PathVariable Long recipeId){
        RecipeResponseDto.RecipeLikeDto recipeLikeDto = recipeService.likeRecipe(recipeLikeRequestDto.getUserId(), recipeId);
        return ResponseEntity.ok(recipeLikeDto);
    }

}
