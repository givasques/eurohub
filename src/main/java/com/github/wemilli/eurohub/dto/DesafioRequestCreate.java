package com.github.wemilli.eurohub.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Desafio;
import com.github.wemilli.eurohub.model.Gestor;
import com.github.wemilli.eurohub.model.StatusDesafio;

public class DesafioRequestCreate {
    private String titulo;
    private String descricao;
    private String categoria;
    private String objetivo;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private StatusDesafio status;
    private Long gestorId;

    public Desafio toModel(Gestor gestor, LocalDateTime now) {
        Desafio desafio = new Desafio();
        desafio.setTitulo(titulo);
        desafio.setDescricao(descricao);
        desafio.setCategoria(categoria);
        desafio.setObjetivo(objetivo);
        desafio.setDataInicio(dataInicio);
        desafio.setDataTermino(dataTermino);
        desafio.setStatus(status);
        desafio.setGestor(gestor);
        desafio.setCreatedAt(now);
        desafio.setUpdatedAt(now);
        return desafio;
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

    public StatusDesafio getStatus() {
        return status;
    }

    public void setStatus(StatusDesafio status) {
        this.status = status;
    }

    public Long getGestorId() {
        return gestorId;
    }

    public void setGestorId(Long gestorId) {
        this.gestorId = gestorId;
    }
}
