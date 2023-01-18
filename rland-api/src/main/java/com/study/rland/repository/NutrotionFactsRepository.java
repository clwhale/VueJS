package com.study.rland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.rland.entity.NutritionFacts;


public interface NutrotionFactsRepository extends JpaRepository<NutritionFacts, Integer> {
    
}
