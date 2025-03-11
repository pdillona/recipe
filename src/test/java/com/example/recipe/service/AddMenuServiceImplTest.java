package com.example.recipe.service;

import com.example.recipe.entity.Menu;
import com.example.recipe.repo.AddMenuRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddMenuServiceImplTest {

    private final AddMenuRepo addMenuRepo;

    public AddMenuServiceImplTest(AddMenuRepo addMenuRepo) {
        this.addMenuRepo = addMenuRepo;
    }

    @Test
    void addMenuTest() {

        Menu menu = new Menu(1, "test", "test_dtls", "testing", "test", "test_menu");

        addMenuRepo.save(menu);
    }
}