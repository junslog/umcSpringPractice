package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Recipe {

    @Id
    @Column(name="RECIPE_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    private String name;

    private String shortDesc;

    private String category;

    private String method;

    private Float rank;

    private String review;

    private Integer likes;

    private Integer scraps;

    private Integer comments;

    private Boolean isTemporallyStored;

    private Boolean isAdminRecipe;

    private Boolean durationOfTime;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;



}
