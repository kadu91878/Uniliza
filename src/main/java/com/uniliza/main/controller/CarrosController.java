package com.uniliza.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniliza.main.entities.CarrosEntity;
import com.uniliza.main.service.CarrosService;


@RestController
@RequestMapping("/carros")
public class CarrosController {
    private final CarrosService carrosService;
    public CarrosController(CarrosService carrosService){
        this.carrosService=carrosService;

    }
    @PostMapping("/")
    public ResponseEntity<CarrosEntity> createCarro(@RequestBody CarrosEntity carro) throws Exception{
        if (carro.getCategoriaId() == null) {
            throw new IllegalArgumentException("categoria não pode ser nulo.");
        }
        Long categoriaId = carro.getCategoriaId().getCategoriaId();
        if (!carrosService.isCategoriaExists(categoriaId)) {
            throw new IllegalArgumentException("Categoria with ID " + carro.getCategoriaId() + " does not exist.");
        }
        CarrosEntity createCarro = carrosService.createCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCarro);
    }

    @GetMapping("/")
    public ResponseEntity<List<CarrosEntity>> getAllCarros(){
        List<CarrosEntity> carros = carrosService.getAllCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrosEntity> getCarrosById(@PathVariable Long id){
        CarrosEntity carro = carrosService.getCarroById(id);
        if(carro!=null){
            return ResponseEntity.ok(carro);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrosEntity> updateCarro(@PathVariable Long id, @RequestBody CarrosEntity updateCarro) throws Exception{
        if (updateCarro.getCategoriaId() == null) {
            throw new IllegalArgumentException("categoria não pode ser nulo.");
        }
        Long categoriaId = updateCarro.getCategoriaId().getCategoriaId();
        if (!carrosService.isCategoriaExists(categoriaId)) {
            throw new IllegalArgumentException("Categoria with ID " + updateCarro.getCategoriaId() + " does not exist.");
        }
        CarrosEntity updated = carrosService.updateCarro(id, updateCarro);
        if(updated!=null){
            return ResponseEntity.ok(updated);

        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Long id){
        carrosService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }
    
}
