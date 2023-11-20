package com.uniliza.main.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniliza.main.entities.CarrosEntity;
import com.uniliza.main.entities.ReservasEntity;
import com.uniliza.main.repository.CarrosRepository;
import com.uniliza.main.repository.ReservasRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservasRepository reservaRepository;

    @Autowired
    private CarrosRepository carroRepository;

    public void registrarReserva(Long idCarro, Date dataInicio, Date dataFim) {
        CarrosEntity carro = carroRepository.findById(idCarro).orElseThrow(() -> new CarroNotFoundException(idCarro));
        
        ReservasEntity reserva = new ReservasEntity();
        reserva.setCar_id(carro);
        reserva.setReservationDate(dataInicio);
        reserva.setDueDate(dataFim);

        reservaRepository.save(reserva);
    }

    // public boolean verificarDisponibilidade(Long idCarro, Date dataInicio, Date dataFim) {
    //     int totalReservas = reservaRepository.verificarDisponibilidade(idCarro, dataInicio, dataFim);
    //     return totalReservas == 0;
    // }
}
