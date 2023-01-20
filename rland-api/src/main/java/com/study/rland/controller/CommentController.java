package com.study.rland.controller;

import org.springframework.web.bind.annotation.RestController;

import com.study.rland.entity.Comment;
import com.study.rland.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @GetMapping("{id}")
    public Comment get(@PathVariable("id") int id) {

        Comment comment = null;

        Optional<Comment> opt = repository.findById(id);
        if (opt.isPresent())
            comment = opt.get();

        return comment;
    }

    @GetMapping
    public List<Comment> getList() {

        List<Comment> list = repository.findAll();

        return list;
    }
}
