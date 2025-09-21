package com.github.wemilli.eurohub.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wemilli.eurohub.dto.ColaboradorRequestCreate;
import com.github.wemilli.eurohub.dto.ColaboradorRequestUpdate;
import com.github.wemilli.eurohub.model.Cargo;
import com.github.wemilli.eurohub.model.Colaborador;
import com.github.wemilli.eurohub.model.Ideia;
import com.github.wemilli.eurohub.repository.CargoRepository;
import com.github.wemilli.eurohub.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
    @Autowired
    ColaboradorRepository colaboradorRepository;
    @Autowired
    CargoRepository cargoRepository;

    public Colaborador createColaborador(ColaboradorRequestCreate dto) {
        Cargo cargo = cargoRepository.findById(dto.getCargoId())
                .orElseThrow(() -> {
                    throw new RuntimeException("Cargo inexistente: ID " + dto.getCargoId());
                });
        LocalDateTime now = LocalDateTime.now();
        return colaboradorRepository.save(dto.toModel(cargo, now));
    }

    public Optional<Colaborador> updateColaborador(Long id, ColaboradorRequestUpdate dto) {
        Cargo cargo = cargoRepository.findById(dto.getCargoId())
        .orElseThrow(() -> {
            throw new RuntimeException("Cargo inexistente: ID " + dto.getCargoId());
        });
        
        return colaboradorRepository.findById(id)
        .map(c -> {
            return colaboradorRepository.save(dto.toModel(c, cargo, LocalDateTime.now()));
        });
    }

    public Boolean deleteColaborador(Long id) {
        if (colaboradorRepository.findById(id).isPresent()) {
            colaboradorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Colaborador> getColaboradorById(Long id) {
        return colaboradorRepository.findById(id);
    }

    public List<Colaborador> getAll() {
        return colaboradorRepository.findAll();
    }

    public List<Ideia> getIdeiasPorColaborador(Long colaboradorId) {
        Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
            .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));

        return colaborador.getIdeias();
    }
}
