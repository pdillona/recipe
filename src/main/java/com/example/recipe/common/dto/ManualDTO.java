package com.example.recipe.common.dto;


import com.example.recipe.common.entity.ManualEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ManualDTO {

    private int id;
    private int rcpId;
    private String content;
    private int step;


/*
    // ManualEntity를 ManualDTO로 변환하는 메서드
    public static ManualDTO fromEntity(ManualEntity manualEntity) {
        if (manualEntity == null) return null;

        return ManualDTO.builder()
                .id(manualEntity.getId())
                .rcp_id(manualEntity.getRcpId())
                .content(manualEntity.getContent())
                .step(manualEntity.getStep())
                .build();
    }*/
}
