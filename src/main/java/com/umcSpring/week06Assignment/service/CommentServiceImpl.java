package com.umcSpring.week06Assignment.service;

import com.umcSpring.week06Assignment.domain.Comment;
import com.umcSpring.week06Assignment.domain.Recipe;
import com.umcSpring.week06Assignment.domain.User;
import com.umcSpring.week06Assignment.repository.CommentRepository;
import com.umcSpring.week06Assignment.repository.RecipeRepository;
import com.umcSpring.week06Assignment.repository.UserRepository;
import com.umcSpring.week06Assignment.web.dto.CommentResponseDto;
import com.umcSpring.week06Assignment.web.dto.CommentResponseDto.CommentViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final CommentRepository commentRepository;
    @Override
    public void writeComment(Long userId, Long recipeId, String content){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NullPointerException("유효하지 않은 유저 아이디입니다.")
        );
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(
                () -> new NullPointerException("유효하지 않은 레시피 아이디입니다.")
        );

//        Comment comment = Comment.builder()
//                        .user(user)
//                        .recipe(recipe).content(content)
//                        .nickName(user.getNickname())
//                        .build();
        Comment comment = new Comment(recipe,user,content, user.getNickname());
        commentRepository.save(comment);
    }

    @Override
    public List<CommentResponseDto.CommentViewDto> getComments(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(
                () -> new NullPointerException("유효하지 않은 레시피 아이디입니다.")
        );
        List<Comment> commentList = commentRepository.findAllByRecipe(recipe);

        List<CommentViewDto> commentViewDtoList = new ArrayList<>();

        for(Comment comment : commentList){
            CommentViewDto commentViewDto = new CommentViewDto(comment.getNickname(), comment.getContent(), comment.getCreatedAt());
            commentViewDtoList.add(commentViewDto);
        }
        return commentViewDtoList;
    }

}