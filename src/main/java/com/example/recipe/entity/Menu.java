package com.example.recipe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="menu")
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String rcpName;

    @Column
    private String rcpPartsDtls;

    @Column
    private String rcpWay2;

    @Column
    private String rcpPat2;

    @Column
    private String hashTag;
}
