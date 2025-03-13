package com.example.recipe.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeApiResponseDTO {

    @JsonProperty("COOKRCP01")
    private RecipeWrapper cookrcp01;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RecipeWrapper {
        private List<RecipeItem> row;
        private int total_count;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RecipeItem {
        @JsonProperty("RCP_SEQ")
        private int rcpSeq;

        @JsonProperty("RCP_NM")
        private String rcpNm;

        @JsonProperty("RCP_PARTS_DTLS")
        private String rcpPartsDtls;

        @JsonProperty("RCP_WAY2")
        private String rcpWay2;

        @JsonProperty("RCP_PAT2")
        private String rcpPat2;

        @JsonProperty("HASH_TAG")
        private String hashTag;

        // 메뉴얼 내용
        @JsonProperty("MANUAL01")
        private String manual01;

        @JsonProperty("MANUAL02")
        private String manual02;

        @JsonProperty("MANUAL03")
        private String manual03;

        @JsonProperty("MANUAL04")
        private String manual04;

        @JsonProperty("MANUAL05")
        private String manual05;

        @JsonProperty("MANUAL06")
        private String manual06;

        @JsonProperty("MANUAL07")
        private String manual07;

        @JsonProperty("MANUAL08")
        private String manual08;

        @JsonProperty("MANUAL09")
        private String manual09;

        @JsonProperty("MANUAL10")
        private String manual10;

        @JsonProperty("MANUAL11")
        private String manual11;

        @JsonProperty("MANUAL12")
        private String manual12;

        @JsonProperty("MANUAL13")
        private String manual13;

        @JsonProperty("MANUAL14")
        private String manual14;

        @JsonProperty("MANUAL15")
        private String manual15;

        @JsonProperty("MANUAL16")
        private String manual16;

        @JsonProperty("MANUAL17")
        private String manual17;

        @JsonProperty("MANUAL18")
        private String manual18;

        @JsonProperty("MANUAL19")
        private String manual19;

        @JsonProperty("MANUAL20")
        private String manual20;
    }
}
