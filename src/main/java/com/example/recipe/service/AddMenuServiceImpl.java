package com.example.recipe.service;

import com.example.recipe.entity.Menu;
import com.example.recipe.repo.AddMenuRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddMenuServiceImpl implements AddMenuService {

    private final AddMenuRepo addMenuRepo;

    @Autowired
    public AddMenuServiceImpl(AddMenuRepo addMenuRepo) {
        this.addMenuRepo = addMenuRepo;
    }

    public boolean addMenu(Menu menu){

        try{
            addMenuRepo.save(menu);
            log.info("Success to save");
            return true;
        } catch (Exception e) {
            log.error("Failed to save");
            return false;
        }

    }
}
