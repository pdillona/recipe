package com.example.recipe.controller;


import com.example.recipe.common.dto.MenuDTO;
import com.example.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/recipes")
@RequiredArgsConstructor
@Log4j2
public class RecipeController {
    

    private final RecipeService recipeService;
    
    
/*    @GetMapping("/search")
    public String searchPage() {


        // return "search";
        return "search_by_user_id";
    }*/


    @GetMapping("/search")
    public List<MenuDTO> searchList(@RequestParam("searchResult") String searchResult) {
        //List<TestDTO>

        log.info("컨트롤러 실행");
        
        List<MenuDTO> result = recipeService.getRecipe(searchResult);

        log.info("result 반화");
        log.info(result);
        
        return result;
    }
    


}
