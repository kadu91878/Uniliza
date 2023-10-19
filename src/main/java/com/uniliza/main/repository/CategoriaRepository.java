package com.uniliza.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniliza.main.entities.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    
}
