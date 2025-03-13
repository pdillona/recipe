package com.example.recipe.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@ToString
@Table(name = "Menu")
public class MenuEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "rcp_name",length = 500)
    private String rcpName;

    @Column(name = "rcp_parts_dtls",length = 500)
    private String rcpPartsDtls;

    @Column(name = "rcp_way2",length = 500)
    private String rcpWay2;

    @Column(name = "rcp_pat2",length = 500)
    private String rcpPat2;

    @Column(name = "hash_tag",length = 500)
    private String hashTag;


 /*   // MenuEntity의 id와 ManualEntity의 pk를 매핑
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private ManualEntity manualEntity;*/

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "menu")
    private List<ManualEntity> manuals;   // 관계 설정을 위한 필드
    
}
