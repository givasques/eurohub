package com.github.wemilli.eurohub.dto;

import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Cargo;
import com.github.wemilli.eurohub.model.Colaborador;
import com.github.wemilli.eurohub.model.StatusColaborador;

public class ColaboradorRequestUpdate {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Long cargoId;
    private StatusColaborador status;

    public Colaborador toModel (Colaborador colaborador, Cargo cargo, LocalDateTime updatedAt) {
        colaborador.setNome(nome);
        colaborador.setCpf(cpf);
        colaborador.setTelefone(telefone);
        colaborador.setEmail(email);
        colaborador.setStatus(status);
        colaborador.setCargo(cargo);
        colaborador.setUpdatedAt(updatedAt);
        return colaborador;
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
    public StatusColaborador getStatus() {
        return status;
    }
    public void setStatus(StatusColaborador status) {
        this.status = status;
    }
}
