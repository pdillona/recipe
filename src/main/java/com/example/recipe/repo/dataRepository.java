package com.example.recipe.repo;


import com.example.recipe.common.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dataRepository extends JpaRepository<MenuEntity, Integer> {






   List<MenuEntity> findByRcpNameContaining(String rcpName); // select ... like %:recipeName%
  
    
    
    

    
}
