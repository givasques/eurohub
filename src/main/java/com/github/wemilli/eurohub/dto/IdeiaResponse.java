package com.github.wemilli.eurohub.dto;

import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Ideia;


public class IdeiaResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private String status;
    private DesafioResponse desafio;
    private ColaboradorResponse colaborador;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public IdeiaResponse toDto(Ideia ideia) {
        this.id = ideia.getId();
        this.titulo = ideia.getTitulo();
        this.descricao = ideia.getDescricao();
        this.status = ideia.getStatus().getMensagem();
        this.desafio = new DesafioResponse().toDto(ideia.getDesafio());
        this.colaborador = new ColaboradorResponse().toDto(ideia.getColaborador());
        this.createdAt = ideia.getCreatedAt();
        this.updatedAt = ideia.getUpdatedAt();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DesafioResponse getDesafio() {
        return desafio;
    }

    public void setDesafio(DesafioResponse desafio) {
        this.desafio = desafio;
    }

    public ColaboradorResponse getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorResponse colaborador) {
        this.colaborador = colaborador;
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
