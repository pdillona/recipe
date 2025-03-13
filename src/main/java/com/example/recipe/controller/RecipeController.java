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


    /*
    
    h2로 db에 crud 테스트 진행
    진행하면서 개선하고자했거나 어려웠던 부분을 기록 개선 후기 까지
    사진 x
    supabase 기본사용법, jap 
    
    브랜치명을 기능에 맞게 파서 사용
    
    검색 외에 기능 없음
    
    검색시 recipe아이디가 아니라 유저는 스트링으로 검색 할 테니 스트링을 받아서 findbyname으로 되련지 모르겠지만 이런걸 써서 해야함
    또한 검색기능은 "토마토 스프" 라고 완성된 제품명을 쳐야 하는 것이 아닌 "토마토" 만 치더라도 토마토와 관련된 레시피가 떠야함
    그렇게 때문에 %like연산도 가능하게 해야함 고려해서 쿼리문 짜는것이 문제일 것이며 쿼리문으로 들어오는 여러 데이터에 대해
    어떤식으로 다시 받을지도 확인해 봐야할 부분
    
    repository에 접근 할 시에 entity로 가는것이 맞다는걸 확인함   
    
    */



}
