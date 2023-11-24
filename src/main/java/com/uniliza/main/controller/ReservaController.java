package com.uniliza.main.controller;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniliza.main.service.ReservaService;

@RestController
@RequestMapping
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/verificar-disponibilidade")
    public String verificarDisponibilidade(
            @RequestParam Long idCarro,
            @RequestParam Date dataInicio,
            @RequestParam Date dataFim) {

        boolean isAvailable = reservaService.verificarDisponibilidade(idCarro, dataInicio, dataFim);

        if (isAvailable) {
            return "Car is available for reservation";
        } else {
            return "Car is not available for reservation";
        }
    }
}