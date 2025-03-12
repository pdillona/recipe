package com.example.recipe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manual")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_id")
    @JsonIgnore
    private Menu menu;

    @Column(name = "step")
    private int step;              // 단계 번호 (1, 2, 3, ...)

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;        // 메뉴얼 내용
}
