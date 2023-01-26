package com.study.rland.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.rland.entity.MenuView;

public interface MenuViewRepository extends JpaRepository<MenuView, Integer> {
    
    @Query(value = "from MenuView mv where mv.name like :query")
    List<MenuView> getViewList(@Param("query") String query, Pageable pageable);
}
