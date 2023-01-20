package com.study.rland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.rland.entity.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
    
}
