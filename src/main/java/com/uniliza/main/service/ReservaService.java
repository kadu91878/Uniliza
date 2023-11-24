package com.uniliza.main.service;

import java.sql.Date;
import java.util.List;

import org.hibernate.mapping.Any;
import org.springframework.stereotype.Service;

import com.uniliza.main.dto.ReservasDTO;
import com.uniliza.main.entities.ReservasEntity;
import com.uniliza.main.repository.ReservasRepository;

@Service
public class ReservaService {

    private final ReservasRepository reservasRepository;

    public ReservaService(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    public List<ReservasDTO> verificarDisponibilidade(Long idCarro, Date dataInicio, Date dataFim) {
        return reservasRepository.verificarDisponibilidade(dataInicio, dataFim);
    }

   
}
