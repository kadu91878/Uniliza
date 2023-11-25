package com.uniliza.main.controller;

import java.sql.Date;
import java.util.List;

import org.hibernate.mapping.Any;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniliza.main.dto.ReservasDTO;
import com.uniliza.main.service.ReservaService;

@RestController
@RequestMapping
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/verificar-disponibilidade")
    public ResponseEntity<List<ReservasDTO>> verificarDisponibilidade(
            @RequestParam Date dataInicio,
            @RequestParam Date dataFim) {
        List<ReservasDTO> reservas = reservaService.verificarDisponibilidade(dataInicio, dataFim);
        return ResponseEntity.ok(reservas);
    }
}

///retornar lista de carros, fazer verificação por ID no front, e criar uma variacao de classe disponivel para mudar o css da box