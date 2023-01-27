package com.study.rland.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.rland.entity.Member;
import com.study.rland.repository.MemberRepository;

@Service
public class DefaultMemberService implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public Member get(String username) {
        Member member = repository.findByUsername(username);
        return member;
    }
    
}
