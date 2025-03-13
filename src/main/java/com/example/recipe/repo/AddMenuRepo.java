package com.example.recipe.repo;

import com.example.recipe.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddMenuRepo extends JpaRepository<Menu, Integer> {
}
