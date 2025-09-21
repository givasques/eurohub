package com.github.wemilli.eurohub.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Desafio;

public class DesafioResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
    private String objetivo;
    private String status;
    private GestorResponse gestor;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DesafioResponse toDto(Desafio desafio) {
        this.id = desafio.getId();
        this.titulo = desafio.getTitulo();
        this.descricao = desafio.getDescricao();
        this.categoria = desafio.getCategoria();
        this.objetivo = desafio.getObjetivo();
        this.status = desafio.getStatus().getMensagem();
        this.gestor = new GestorResponse().toDto(desafio.getGestor());
        this.dataInicio = desafio.getDataInicio();
        this.dataTermino = desafio.getDataTermino();
        this.createdAt = desafio.getCreatedAt();
        this.updatedAt = desafio.getUpdatedAt();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GestorResponse getGestor() {
        return gestor;
    }

    public void setGestor(GestorResponse gestor) {
        this.gestor = gestor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
