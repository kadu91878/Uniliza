package com.uniliza.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uniliza.main.entities.CarrosEntity;

@Repository
public interface CarrosRepository extends JpaRepository<CarrosEntity, Long> {
    
    CarrosEntity findByPlaca(String placa);
}
