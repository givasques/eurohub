package com.github.wemilli.eurohub.dto;

import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Colaborador;
import com.github.wemilli.eurohub.model.Desafio;
import com.github.wemilli.eurohub.model.Ideia;
import com.github.wemilli.eurohub.model.StatusIdeia;


public class IdeiaRequestCreate {
    private String titulo;
    private String descricao;
    private Long desafioId;
    private Long colaboradorId;

    public Ideia toModel(Desafio desafio, Colaborador colaborador, LocalDateTime now) {
        Ideia ideia = new Ideia();
        ideia.setTitulo(titulo);
        ideia.setDescricao(descricao);
        ideia.setStatus(StatusIdeia.ANALISE);
        ideia.setDesafio(desafio);
        ideia.setColaborador(colaborador);
        ideia.setCreatedAt(now);
        ideia.setUpdatedAt(now);
        return ideia;
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
    public Long getDesafioId() {
        return desafioId;
    }
    public void setDesafioId(Long desafioId) {
        this.desafioId = desafioId;
    }
    public Long getColaboradorId() {
        return colaboradorId;
    }
    public void setColaboradorId(Long colaboradorId) {
        this.colaboradorId = colaboradorId;
    }
}