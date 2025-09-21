package com.github.wemilli.eurohub.dto;

import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Ideia;
import com.github.wemilli.eurohub.model.StatusIdeia;

public class IdeiaRequestUpdate {
    private String titulo;
    private String descricao;
    private StatusIdeia status;

    public Ideia toModel(Ideia ideia, LocalDateTime now) {
        ideia.setTitulo(titulo);
        ideia.setDescricao(descricao);
        ideia.setStatus(status);
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
    public StatusIdeia getStatus() {
        return status;
    }
    public void setStatus(StatusIdeia status) {
        this.status = status;
    }
}
