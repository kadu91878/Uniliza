package com.uniliza.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uniliza.main.entities.CarrosEntity;
import com.uniliza.main.entities.CategoriaEntity;
import com.uniliza.main.repository.CarrosRepository;
import com.uniliza.main.repository.CategoriaRepository;

@Service
public class CarrosService {
    private final CarrosRepository carrosRepository;
    private final CategoriaRepository categoriaRepository;

    public CarrosService(CarrosRepository carrosRepository, CategoriaRepository categoriaRepository) {
        this.carrosRepository = carrosRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public CarrosEntity createCarro(CarrosEntity carro) throws Exception {
        CarrosEntity existingCarro = carrosRepository.findByPlaca(carro.getPlaca());
        if (existingCarro != null) {
            throw new Exception("Carro já cadastrado");
        }
        // Set the associated CategoriaEntity by fetching it from the database
        if (carro.getCategoria() != null) {
            carro.setCategoria(categoriaRepository.findById(carro.getCategoria().getCategoriaId()).orElse(null));
        }
        return carrosRepository.save(carro);
    }

    public CarrosEntity getCarroById(Long id) {
        return carrosRepository.findById(id).orElse(null);
    }

    public List<CarrosEntity> getAllCarros() {
        return carrosRepository.findAll();
    }

    public CarrosEntity updateCarro(Long id, CarrosEntity updateCarro) throws Exception {
        CarrosEntity existingCarro = carrosRepository.findById(id).orElse(null);
        if (existingCarro == null) {
            throw new Exception("Carro não encontrado");
        }
        // Update car information and category if needed
        existingCarro.setNome(updateCarro.getNome());
        existingCarro.setMarca(updateCarro.getMarca());
        existingCarro.setPlaca(updateCarro.getPlaca());
        existingCarro.setAno(updateCarro.getAno());
        existingCarro.setDisponibilidade(updateCarro.getDisponibilidade());
        if (updateCarro.getCategoria() != null) {
            existingCarro.setCategoria(categoriaRepository.findById(updateCarro.getCategoria().getCategoriaId()).orElse(null));
        }
        return carrosRepository.save(existingCarro);
    }

    public void deleteCarro(Long id) {
        carrosRepository.deleteById(id);
    }

    public boolean isCategoriaExists(Long categoriaId) {
        CategoriaEntity categoria = categoriaRepository.findById(categoriaId).orElse(null);
        return categoria != null;
    }

}
