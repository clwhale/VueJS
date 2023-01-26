package com.study.rland.service;

import java.util.List;

import com.study.rland.entity.Menu;
import com.study.rland.entity.MenuView;

public interface MenuService {
    Menu get(int id);
    List<Menu> getList(int page, int size);
    List<MenuView> getViewList(String query, int page, int size);
    Menu create(Menu menu);
    Menu update(Menu menu);
    void delete(int id);
}
