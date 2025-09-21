package com.github.wemilli.eurohub.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wemilli.eurohub.dto.DesafioRequestCreate;
import com.github.wemilli.eurohub.dto.DesafioRequestUpdate;
import com.github.wemilli.eurohub.model.Desafio;
import com.github.wemilli.eurohub.model.Gestor;
import com.github.wemilli.eurohub.model.Ideia;
import com.github.wemilli.eurohub.repository.DesafioRepository;
import com.github.wemilli.eurohub.repository.GestorRepository;

@Service
public class DesafioService {
    @Autowired
    private DesafioRepository desafioRepository;

    @Autowired
    private GestorRepository gestorRepository;

    public Desafio createDesafio (DesafioRequestCreate dto) {
        Gestor gestor = gestorRepository.findById(dto.getGestorId())
        .orElseThrow (() -> {
            throw new RuntimeException("Gestor inexistente: ID " + dto.getGestorId());
        });

        return desafioRepository.save(dto.toModel(gestor, LocalDateTime.now()));
    }

    public Optional<Desafio> updateDesafio (Long id, DesafioRequestUpdate dto) {
        Gestor gestor = gestorRepository.findById(dto.getGestorId())
        .orElseThrow (() -> {
            throw new RuntimeException("Gestor inexistente: ID " + dto.getGestorId());
        });

        return desafioRepository.findById(id)
        .map (d -> {
            return desafioRepository.save(dto.toModel(d, gestor, LocalDateTime.now()));
        });
    }

    public Boolean deleteDesafio (Long id) {
        if (desafioRepository.findById(id).isPresent()) {
            desafioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Desafio> getDesafioById (Long id) {
        return desafioRepository.findById(id);
    }

    public List<Desafio> getAll () {
        return desafioRepository.findAll();
    }

    public List<Ideia> getIdeiasPorDesafio(Long desafioId) {
        Desafio desafio = desafioRepository.findById(desafioId)
            .orElseThrow(() -> new RuntimeException("Desafio não encontrado"));

        return desafio.getIdeias();
    }
}
