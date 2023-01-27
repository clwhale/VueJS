package com.study.rland.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.study.rland.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query(value = "from member where username :username")
    Member findByUsername(String username);

}
