package com.study.rland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.rland.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    
}
