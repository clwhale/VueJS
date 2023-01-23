package com.study.rland.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.rland.entity.Menu;

// public interface MenuRepository { //extends JpaRepository<Menu, Integer> {
//     List<Menu> getList(int offset, int size);
//     Menu get(int id);
//     Menu create(Menu menu);
// }
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    
}
