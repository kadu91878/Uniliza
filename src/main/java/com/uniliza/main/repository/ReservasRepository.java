package com.uniliza.main.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniliza.main.entities.ReservasEntity;

public interface ReservasRepository extends JpaRepository<ReservasEntity, Long> {

    @Query("SELECT COUNT(r.carro.id) FROM Reserva r " +
           "WHERE r.carro.id = :idCarro " +
           "AND (:dataInicio BETWEEN r.dataInicio AND r.dataFim " +
           "OR :dataFim BETWEEN r.dataInicio AND r.dataFim " +
           "OR r.dataInicio BETWEEN :dataInicio AND :dataFim)")
    int verificarDisponibilidade(@Param("idCarro") Long idCarro,
                                 @Param("dataInicio") Date dataInicio,
                                 @Param("dataFim") Date dataFim);

    
}
