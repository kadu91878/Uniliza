package com.uniliza.main.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.uniliza.main.repository.ReservasRepository;

@Service
public class ReservaService {

    private final ReservasRepository reservasRepository;

    public ReservaService(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    public boolean verificarDisponibilidade(Long idCarro, Date dataInicio, Date dataFim) {
        if(reservasRepository.verificarDisponibilidade(idCarro, dataInicio, dataFim) == 0) {
            return true;
        }
        return false;
    }

   
}
