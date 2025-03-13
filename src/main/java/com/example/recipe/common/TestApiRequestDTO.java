package com.example.recipe.common;

import lombok.Data;

@Data
public class TestApiRequestDTO {
    
    
    private String RCP_NM;  // 메뉴명
    private String RCP_PARTS_DTLS;  // 재료정보1
    private String CHNG_DT;  // 변경일자
    private String RCP_PAT2;  // 요리종류

    // RCP_NM RCP_PARTS_DTLS  RCP_WAY2 RCP_PAT2 HASH_TAG MANUAL01~MANUAL20
    
}
