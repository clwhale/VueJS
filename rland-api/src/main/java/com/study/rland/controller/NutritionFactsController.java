package com.study.rland.controller;

import org.springframework.web.bind.annotation.RestController;

import com.study.rland.entity.NutritionFacts;
import com.study.rland.repository.NutrotionFactsRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("nutritions")
public class NutritionFactsController {
    
    @Autowired
    private NutrotionFactsRepository repository;

    @GetMapping("{id}")
    public NutritionFacts get(@PathVariable("id") int id) {

        NutritionFacts nutrition = null;

        Optional<NutritionFacts> opt = repository.findById(id);
        if(opt.isPresent())
            nutrition = opt.get();

        return nutrition;
    }

    @GetMapping
    public List<NutritionFacts> getList(){

            List<NutritionFacts> list = repository.findAll();

            return list;
    }
}
