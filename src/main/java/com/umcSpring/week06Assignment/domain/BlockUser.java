package com.umcSpring.week06Assignment.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class BlockUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long blockId;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    private Long blockUserId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
