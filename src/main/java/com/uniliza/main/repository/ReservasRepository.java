package com.uniliza.main.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniliza.main.dto.ReservasDTO;
import com.uniliza.main.entities.ReservasEntity;

public interface ReservasRepository extends JpaRepository<ReservasEntity, Long> {

@Query(value = "SELECT r.id AS id, r.reservation_date AS reservationDate, r.due_date AS dueDate, r.car_id AS carId " +
            "FROM uniliza.reservas r " +
            "WHERE (:dataInicio BETWEEN r.reservation_date AND r.due_date " +
            "OR :dataFim BETWEEN r.reservation_date AND r.due_date " +
            "OR r.reservation_date BETWEEN :dataInicio AND :dataFim)", nativeQuery = true)
    List<ReservasDTO> verificarDisponibilidade(
            @Param("dataInicio") Date dataInicio,
            @Param("dataFim") Date dataFim);
}
