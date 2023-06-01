package com.umcSpring.week06Assignment.repository;

import com.umcSpring.week06Assignment.domain.Recipe;
import com.umcSpring.week06Assignment.domain.User;
import com.umcSpring.week06Assignment.domain.UserRecipeLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRecipeLikeRepository extends JpaRepository<UserRecipeLike, Long> {
    Optional<UserRecipeLike> findByUserAndRecipe(User user, Recipe recipe);
    void deleteByUserAndRecipe(User user, Recipe recipe);
}
