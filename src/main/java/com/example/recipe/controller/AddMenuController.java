package com.example.recipe.controller;

import com.example.recipe.entity.Menu;
import com.example.recipe.service.AddMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddMenuController {

    private final AddMenuService addMenuService;

    @Autowired
    public AddMenuController(AddMenuService addMenuService) {
        this.addMenuService = addMenuService;
    }

    public boolean addMenu(){

        /* 나중에 api 호출로 변경하기 */
        Menu menu = new Menu(1, "test", "test_dtls", "testing", "test", "test_menu");

        addMenuService.addMenu(menu);

        return true;
    }

}
