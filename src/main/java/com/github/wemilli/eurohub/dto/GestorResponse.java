package com.github.wemilli.eurohub.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Cargo;
import com.github.wemilli.eurohub.model.Gestor;

public class GestorResponse {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Cargo cargo;
    private LocalDate dataAdmissao;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public GestorResponse toDto(Gestor gestor) {
        this.id = gestor.getId();
        this.nome = gestor.getNome();
        this.cpf = gestor.getCpf();
        this.telefone = gestor.getTelefone();
        this.email = gestor.getEmail();
        this.cargo = gestor.getCargo();
        this.dataAdmissao = gestor.getDataAdmissao();
        this.status = gestor.getStatus().getMensagem();
        this.createdAt = gestor.getCreatedAt();
        this.updatedAt = gestor.getUpdatedAt();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
