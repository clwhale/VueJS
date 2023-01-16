package com.study.rland.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 주로 view를 반환하기 위해 사용했던 @Controller와 달리
 * Data를 반환하기 위해 @ResponseBody를 활용하는 데
 * @RestController는 @Controller에 @ResponseBody가 추가된 것으로
 * HTTP응답데이터(body)에 자바 객체가 매핑되어 전달 된다.
 */
@RestController
@RequestMapping("menus")
public class MenuController {

    // EX: /menus?p=1&s=15
    @GetMapping
    public String getList(
        @RequestParam(name = "p", defaultValue = "1") int page,
        @RequestParam(name = "s", defaultValue = "15") int size) {
        return String.format("get Menu List:page=%d, size%d", page, size);
    }

    // EX: /menus/2
    @GetMapping("{id}")
    public String get(int id) {
        return "get Menu";
    }

    @PostMapping
    public String add() {
        return "add Menu";
    }
    
    @PutMapping
    public String update() {
        return "update Menu";
    }
    
    @DeleteMapping
    public String delete() {
        return "delete Menu";
    }
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
