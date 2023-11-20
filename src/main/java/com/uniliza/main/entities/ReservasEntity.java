package com.uniliza.main.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "reservas")
@Table(name = "reservas")
@EqualsAndHashCode(of = "id")
public class ReservasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date reservationDate;
    private Date dueDate;
    @ManyToOne
    @JoinColumn(name = "id")
    private CarrosEntity car_id;

}
