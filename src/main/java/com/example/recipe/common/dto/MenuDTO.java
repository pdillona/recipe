package com.example.recipe.common.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    private int id;
    private String rcpName;
    private String rcpPartsDtls;
    private String rcpWay2;
    private String rcpPat2;
    private String hashTag;
    private List<ManualDTO> manuals;  // 연관된 Manual 정보

/*    public MenuDTO(int id, String rcp_name, String rec_parts_dtls, String rcp_way2, String rcp_pat2, String hash_tag) {
        this.id = id;
        this.rcpName = rcp_name;
        this.rcpPartsDtls = rec_parts_dtls;
        this.rcpWay2 = rcp_way2;
        this.rcpPat2 = rcp_pat2;
        this.hashTag = hash_tag;
    }
    */
}
