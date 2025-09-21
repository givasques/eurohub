package com.github.wemilli.eurohub.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wemilli.eurohub.dto.GestorRequestCreate;
import com.github.wemilli.eurohub.dto.GestorRequestUpdate;
import com.github.wemilli.eurohub.model.Cargo;
import com.github.wemilli.eurohub.model.Desafio;
import com.github.wemilli.eurohub.model.Gestor;
import com.github.wemilli.eurohub.repository.CargoRepository;
import com.github.wemilli.eurohub.repository.GestorRepository;

@Service
public class GestorService {
    @Autowired
    private GestorRepository gestorRepository;

    @Autowired
    private CargoRepository cargoRepository;

    public Gestor createGestor(GestorRequestCreate dto) {
        Cargo cargo = cargoRepository.findById(dto.getCargoId())
                .orElseThrow(() -> {
                    throw new RuntimeException("Cargo inexistente: ID " + dto.getCargoId());
                });
        LocalDateTime now = LocalDateTime.now();
        return gestorRepository.save(dto.toModel(cargo, now));
    }

    public Optional<Gestor> updateGestor(Long id, GestorRequestUpdate dto) {
        Cargo cargo = cargoRepository.findById(dto.getCargoId())
        .orElseThrow(() -> {
            throw new RuntimeException("Cargo inexistente: ID " + dto.getCargoId());
        });
        
        return gestorRepository.findById(id)
        .map(g -> {
            return gestorRepository.save(dto.toModel(g, cargo, LocalDateTime.now()));
        });
    }

    public Boolean deleteGestor(Long id) {
        if (gestorRepository.findById(id).isPresent()) {
            gestorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Gestor> getGestorById(Long id) {
        return gestorRepository.findById(id);
    }

    public List<Gestor> getAll() {
        return gestorRepository.findAll();
    }

    public List<Desafio> getDesafiosPorGestor(Long gestorId) {
        Gestor gestor = gestorRepository.findById(gestorId)
            .orElseThrow(() -> new RuntimeException("Gestor não encontrado"));

        return gestor.getDesafios();
    }
}
