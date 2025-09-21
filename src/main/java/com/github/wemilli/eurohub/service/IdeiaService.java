package com.github.wemilli.eurohub.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wemilli.eurohub.dto.IdeiaRequestCreate;
import com.github.wemilli.eurohub.dto.IdeiaRequestUpdate;
import com.github.wemilli.eurohub.model.Colaborador;
import com.github.wemilli.eurohub.model.Desafio;
import com.github.wemilli.eurohub.model.Ideia;
import com.github.wemilli.eurohub.repository.ColaboradorRepository;
import com.github.wemilli.eurohub.repository.DesafioRepository;
import com.github.wemilli.eurohub.repository.IdeiaRepository;

@Service
public class IdeiaService {
    @Autowired
    IdeiaRepository ideiaRepository;

    @Autowired
    DesafioRepository desafioRepository;

    @Autowired
    ColaboradorRepository colaboradorRepository;

    public Ideia createIdeia (IdeiaRequestCreate dto) {
        Desafio desafio = desafioRepository.findById(dto.getDesafioId())
        .orElseThrow (() -> {
            throw new RuntimeException("Desafio inexistente: ID " + dto.getDesafioId());
        });

        Colaborador colaborador = colaboradorRepository.findById(dto.getColaboradorId())
        .orElseThrow (() -> {
            throw new RuntimeException("Colaborador inexistente: ID " + dto.getColaboradorId());
        });

        return ideiaRepository.save(dto.toModel(desafio, colaborador, LocalDateTime.now()));
    }

    public Optional<Ideia> updateIdeia (Long id, IdeiaRequestUpdate dto) {
        return ideiaRepository.findById(id)
        .map (i -> {
            return ideiaRepository.save(dto.toModel(i, LocalDateTime.now()));
        });
    }

    public Boolean deleteIdeia (Long id) {
        if (ideiaRepository.findById(id).isPresent()) {
            ideiaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Ideia> getIdeiaById (Long id) {
        return ideiaRepository.findById(id);
    }

    public List<Ideia> getAll () {
        return ideiaRepository.findAll();
    }
}
