package com.study.rland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.rland.entity.Member;
import com.study.rland.service.MemberService;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    private MemberService service;
    
    @GetMapping
    public List<Member> getList() {
        return null;
    }

    @GetMapping("{username}")
    public Member get(@PathVariable("username") String username) {
        return service.get(username);
    }
}
