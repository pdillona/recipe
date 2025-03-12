package com.example.recipe.controller;

import com.example.recipe.entity.Menu;
import com.example.recipe.service.AddRecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
@Slf4j
public class AddRecipeController {

    private final AddRecipeService addRecipeService;

    /**
     * 공공 API에서 레시피 데이터를 가져와 저장
     * @param startIdx 시작 인덱스
     * @param endIdx 종료 인덱스
     * @return 결과 정보
     */
    @PostMapping("/fetch")
    public ResponseEntity<Map<String, Object>> fetchRecipes(
            @RequestParam(defaultValue = "1") int startIdx,
            @RequestParam(defaultValue = "10") int endIdx) {

        log.info("Fetching recipes from {} to {}", startIdx, endIdx);

        int savedCount = addRecipeService.fetchAndSaveRecipes(startIdx, endIdx);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("savedCount", savedCount);
        response.put("message", String.format("%d 개의 레시피를 저장했습니다.", savedCount));

        return ResponseEntity.ok(response);
    }

}
