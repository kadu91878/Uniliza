package com.uniliza.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "carros")
@Data
@Table(name = "carros")
@EqualsAndHashCode(of = "id")
public class CarrosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;
    @Column(unique = true)
    private String placa;
    private Integer ano;
    @ManyToOne
    @JoinColumn(name = "categoriaId")
    private CategoriaEntity categoria;

}
