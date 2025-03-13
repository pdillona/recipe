package com.example.recipe.service;

import com.example.recipe.common.RecipeApiResponseDTO;
import com.example.recipe.entity.Manual;
import com.example.recipe.entity.Menu;
import com.example.recipe.repo.AddMenuRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddRecipeServiceImpl implements AddRecipeService {

    private final AddMenuRepo addMenuRepo;
    private final RestTemplate restTemplate;

    @Value("${api.food.key}")
    private String apiKey;

    @Value("${api.food.service-id}")
    private String serviceId;

    @Value("${api.food.base-url}")
    private String baseUrl;

    /**
     * 공공 API에서 레시피 데이터를 가져와 DB에 저장
     * @param startIdx 시작 인덱스
     * @param endIdx 종료 인덱스
     * @return 저장된 레시피 수
     */
    @Transactional
    public int fetchAndSaveRecipes(int startIdx, int endIdx) {
        try {
            String apiUrl = String.format("%s/api/%s/%s/json/%d/%d",
                    baseUrl, apiKey, serviceId, startIdx, endIdx);

            log.info("Calling API: {}", apiUrl);

            ResponseEntity<RecipeApiResponseDTO> response =
                    restTemplate.getForEntity(apiUrl, RecipeApiResponseDTO.class);

            if (response.getBody() == null || response.getBody().getCookrcp01() == null) {
                log.warn("No data received from API");
                return 0;
            }

            List<RecipeApiResponseDTO.RecipeItem> items = response.getBody().getCookrcp01().getRow();
            if (items == null || items.isEmpty()) {
                log.warn("Empty data received from API");
                return 0;
            }

            log.info("Received {} recipes from API", items.size());

            List<Menu> menus = items.stream()
                    .map(this::convertToEntity)
                    .collect(Collectors.toList());

            // 변환된 메뉴 객체 로깅 추가
            for (Menu menu : menus) {
                log.info("변환된 메뉴: id={}, name={}, 재료={}",
                        menu.getId(), menu.getRcpName(), menu.getRcpPartsDtls());

                // 각 메뉴얼도 로깅
                for (Manual manual : menu.getManuals()) {
                    log.info("  - 메뉴얼 step={}, content={}",
                            manual.getStep(), manual.getContent());
                }
            }

            addMenuRepo.saveAll(menus);

            log.info("Saved {} recipes to database", menus.size());

            return menus.size();
        } catch (Exception e) {
            log.error("Error fetching and saving recipes", e);
            throw new RuntimeException("Failed to fetch and save recipes", e);
        }
    }

    /**
     * DTO를 엔티티로 변환
     */
    private Menu convertToEntity(RecipeApiResponseDTO.RecipeItem item) {
        // 기본 레시피 정보 생성
        Menu menu = Menu.builder()
                .rcpName(item.getRcpNm())
                .rcpPartsDtls(item.getRcpPartsDtls())
                .rcpWay2(item.getRcpWay2())
                .rcpPat2(item.getRcpPat2())
                .hashTag(item.getHashTag())
                .build();

        // 메뉴얼 정보 추가
        addManualIfNotEmpty(menu, 1, item.getManual01());
        addManualIfNotEmpty(menu, 2, item.getManual02());
        addManualIfNotEmpty(menu, 3, item.getManual03());
        addManualIfNotEmpty(menu, 4, item.getManual04());
        addManualIfNotEmpty(menu, 5, item.getManual05());
        addManualIfNotEmpty(menu, 6, item.getManual06());
        addManualIfNotEmpty(menu, 7, item.getManual07());
        addManualIfNotEmpty(menu, 8, item.getManual08());
        addManualIfNotEmpty(menu, 9, item.getManual09());
        addManualIfNotEmpty(menu, 10, item.getManual10());
        addManualIfNotEmpty(menu, 11, item.getManual11());
        addManualIfNotEmpty(menu, 12, item.getManual12());
        addManualIfNotEmpty(menu, 13, item.getManual13());
        addManualIfNotEmpty(menu, 14, item.getManual14());
        addManualIfNotEmpty(menu, 15, item.getManual15());
        addManualIfNotEmpty(menu, 16, item.getManual16());
        addManualIfNotEmpty(menu, 17, item.getManual17());
        addManualIfNotEmpty(menu, 18, item.getManual18());
        addManualIfNotEmpty(menu, 19, item.getManual19());
        addManualIfNotEmpty(menu, 20, item.getManual20());

        return menu;
    }

    /**
     * 내용이 있는 경우에만 메뉴얼을 추가
     */
    private void addManualIfNotEmpty(Menu menu, int step, String content) {
        if (content != null && !content.trim().isEmpty() && !content.equals("-")) {
            menu.addManual(step, content);
        }
    }

}
