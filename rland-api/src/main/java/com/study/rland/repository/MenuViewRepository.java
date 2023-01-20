package com.study.rland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.rland.entity.MenuView;

public interface MenuViewRepository extends JpaRepository<MenuView, Integer> {
    
}
