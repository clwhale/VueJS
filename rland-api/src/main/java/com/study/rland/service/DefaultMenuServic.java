package com.study.rland.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.rland.entity.Menu;
import com.study.rland.repository.MenuRepository;

@Service
public class DefaultMenuServic implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public Menu get(int id) {

        Menu menu = null;

        Optional<Menu> opt = repository.findById(id);
        if (opt.isPresent()) {
            menu = opt.get();
        }
        return menu;
    }

    @Override
    public List<Menu> getList(int page, int size) {

        List<Menu> list = repository.findAll();

        return list;
    }

    @Override
    public Menu create(Menu menu) {

        Menu newOne = repository.save(menu);

        return newOne;
    }

    @Override
    public Menu update(Menu menu) {

        menu.getName();
        menu.getPrice();

        Menu oldOne = get(menu.getId());

        if (menu.getName() != null)
            oldOne.setName(menu.getName());
        if (menu.getPrice() != 0)
            oldOne.setPrice(menu.getPrice());

        Menu newOne = repository.save(oldOne);

        return newOne;
    }

    @Override
    public void delete(int id) {

    }

}
