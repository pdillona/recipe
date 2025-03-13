package com.example.recipe.common.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Manual")
public class ManualEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

 /*   @Column(name = "rcp_id", length = 500, nullable = false, unique = true) //rcpId를 유일하게 (unique = true) 설정하여 MenuEntity와 1:1 관계를 매핑할 수 있도록 구성.
    private int rcpId;*/

    @Column(name = "content",length = 500)
    private String content;

    @Column(name = "step",length = 500)
    private int step;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_id", referencedColumnName = "id")
    private MenuEntity menu;
    
}
