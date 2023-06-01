package com.umcSpring.week06Assignment.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="RECIPE_ID")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name="USER_Id")
    private User user;

    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private String nickname;

    @Builder
    public Comment(Recipe recipe, User user, String content, String nickname){
        this.recipe = recipe;
        this.user = user;
        this.content = content;
        this.nickname = nickname;
    }

}
