package com.example.recipe.entity;

import com.example.recipe.entity.Manual;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    @Id
    @Column(name = "id")
    private int id;        // 일련번호(기존 rcpSeq)

    @Column(name = "rcp_name")
    private String rcpName;   // 메뉴명

    @Lob
    @Column(name = "rcp_parts_dtls", columnDefinition = "TEXT")
    private String rcpPartsDtls;  // 재료정보

    @Column(name = "rcp_way2")
    private String rcpWay2;       // 조리방법

    @Column(name = "rcp_pat2")
    private String rcpPat2;       // 요리종류

    @Column(name = "hash_tag")
    private String hashTag;       // 해시태그

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Manual> manuals = new ArrayList<>();

    /**
     * 메뉴얼 단계 추가 메소드
     */
    public void addManual(int step, String content) {
        Manual manual = Manual.builder()
                .menu(this)
                .step(step)
                .content(content)
                .build();

        this.manuals.add(manual);
    }
}