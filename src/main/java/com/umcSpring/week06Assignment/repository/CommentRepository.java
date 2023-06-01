package com.umcSpring.week06Assignment.repository;

import com.umcSpring.week06Assignment.domain.Comment;
import com.umcSpring.week06Assignment.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByRecipe(Recipe recipe);
}
