package com.uniliza.main.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniliza.main.entities.ReservasEntity;

public interface ReservasRepository extends JpaRepository<ReservasEntity, Long> {

    @Query( value = "SELECT COUNT(r.car_id) FROM uniliza.reservas r " + 
    "WHERE r.car_id = :idCarro " + 
    "AND (:dataInicio BETWEEN r.reservation_date  AND r.due_date " + 
    "OR :dataFim BETWEEN r.reservation_date  AND r.due_date " + 
    "OR r.reservation_date BETWEEN :dataInicio AND :dataFim)", nativeQuery = true)
    int verificarDisponibilidade(@Param("idCarro") Long idCarro,
                                 @Param("dataInicio") Date dataInicio,
                                 @Param("dataFim") Date dataFim);

    
}
