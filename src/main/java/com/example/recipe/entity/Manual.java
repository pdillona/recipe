package com.example.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="manual")
@Getter
@RequiredArgsConstructor
@ToString
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="rcpId", nullable = false)
    private Menu menu;

    @Column
    private int manualNumber;

}
