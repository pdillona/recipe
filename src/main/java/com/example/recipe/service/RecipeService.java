package com.example.recipe.service;

import com.example.recipe.common.dto.ManualDTO;
import com.example.recipe.common.dto.MenuDTO;
import com.example.recipe.common.entity.MenuEntity;
import com.example.recipe.repo.dataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/*
    작성일: 2025.03.12
    기능: 컨트롤러에서 받은 데이터를 레파지토리로 보낸뒤 반환된 값을 dto로 변환해서 controller로 반환
*/
@Log4j2
@Service
@RequiredArgsConstructor
public class RecipeService {


    private final dataRepository dataRepository;


    public List<MenuDTO> getRecipe(String recipeName) {
        List<MenuEntity> entities = dataRepository.findByRcpNameContaining(recipeName);


        log.info("entities레포에서 돌아온값: "+entities);

        return entities.stream()
                .map(this::convertToMenuDTO)  // 엔티티를 DTO로 변환하는 메서드
                .collect(Collectors.toList());
    }

    
    
    // MenuEntity를 MenuDTO로 변환하는 메서드
    private MenuDTO convertToMenuDTO(MenuEntity menuEntity) {
        MenuDTO menuDTO = new MenuDTO(
                menuEntity.getId(),
                menuEntity.getRcpName(),
                menuEntity.getRcpPartsDtls(),
                menuEntity.getRcpWay2(),
                menuEntity.getRcpPat2(),
                menuEntity.getHashTag(),
                menuEntity.getManuals().stream()  // 관련된 매뉴얼들
                        .map(manualEntity -> new ManualDTO(
                                manualEntity.getId(),
                                manualEntity.getMenu().getId(),
                                manualEntity.getContent(),
                                manualEntity.getStep()
                        ))
                        .collect(Collectors.toList())
        );
        
        log.info("변환환 menuDTO값: " + menuDTO);
        return menuDTO;
    
    } // getRecipe end

} // class end
