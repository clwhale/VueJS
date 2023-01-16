package com.study.rland.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.rland.entity.Menu;

import jakarta.validation.Valid;

/**
 * 주로 view를 반환하기 위해 사용했던 @Controller와 달리
 * Data를 반환하기 위해 @ResponseBody를 활용하는 데
 * 
 * @RestController는 @Controller에 @ResponseBody가 추가된 것으로
 *                  HTTP응답데이터(body)에 자바 객체가 매핑되어 전달 된다.
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

    /**
     * EX: /menus/2
     * 
     * @param id
     * @return
     *         MediaType을 사용해서 들어오거나 나가는 데이터 속성을 강제함으로써 오류를 줄일 수 있다.
     *         produces는 반환하는 데이터 타입을 정의한다.
     */
    @GetMapping(path = "{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    /**
     * ResponseEntity는 HTTP요청(Request) 또는 응답(Response)에 해당하는 Header와 Body를 포함하는
     * 클래스이다.
     * 
     * @param id
     * @return
     */
    public ResponseEntity<Menu> get(@PathVariable int id) {

        Menu menu = Menu
                .builder()
                .name("아이스 카페라떼")
                .price(6000)
                .build();

        return new ResponseEntity<Menu>(HttpStatus.OK);
    }

    /**
     * consumes는 들어오는 데이터 타입을 정의할때 이용한다.
     * 
     * @param menu
     * @return
     */
    @PostMapping(produces = {}, consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public Menu create(@Valid @RequestBody Menu menu) {

        System.out.println(menu);

        /**
         * db에 저장하고
         * 방금 저장한 데이터를 다시 가져와서
         */

        return menu;
    }

    // Json이 기본이라 consume을 설정하지 않음
    @PutMapping
    public Menu update(@RequestBody Menu menu) {

        // error
        Menu m = null;
        m.getId();

        return menu;
    }

    // 삭제 메소드는 반환할게 없음
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
