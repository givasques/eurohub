package com.github.wemilli.eurohub.dto;

import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Cargo;
import com.github.wemilli.eurohub.model.Gestor;
import com.github.wemilli.eurohub.model.StatusGestor;

public class GestorRequestUpdate {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Long cargoId;
    private StatusGestor status;

    public Gestor toModel (Gestor gestor, Cargo cargo, LocalDateTime updatedAt) {
        gestor.setNome(nome);
        gestor.setCpf(cpf);
        gestor.setTelefone(telefone);
        gestor.setEmail(email);
        gestor.setStatus(status);
        gestor.setCargo(cargo);
        gestor.setUpdatedAt(updatedAt);
        return gestor;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getCargoId() {
        return cargoId;
    }
    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }
    public StatusGestor getStatus() {
        return status;
    }
    public void setStatus(StatusGestor status) {
        this.status = status;
    }
}
