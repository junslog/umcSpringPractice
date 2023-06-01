package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BEV_ID")
    private Long id;

    private String category;

    private String photoUrl;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;


}
