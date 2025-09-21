package com.github.wemilli.eurohub.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Cargo;
import com.github.wemilli.eurohub.model.Gestor;
import com.github.wemilli.eurohub.model.StatusGestor;

public class GestorRequestCreate {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Long cargoId;
    private LocalDate dataAdmissao;
    private StatusGestor status;

    public Gestor toModel(Cargo cargo, LocalDateTime now) {
        Gestor gestor = new Gestor();
        gestor.setNome(nome);
        gestor.setCpf(cpf);
        gestor.setTelefone(telefone);
        gestor.setEmail(email);
        gestor.setCargo(cargo);
        gestor.setDataAdmissao(dataAdmissao);
        gestor.setStatus(status);
        gestor.setCreatedAt(now);
        gestor.setUpdatedAt(now);
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

    public void setCargoId(Long idCargo) {
        this.cargoId = idCargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public StatusGestor getStatus() {
        return status;
    }

    public void setStatus(StatusGestor status) {
        this.status = status;
    }
}
