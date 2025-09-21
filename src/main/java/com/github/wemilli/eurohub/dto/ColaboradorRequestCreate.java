package com.github.wemilli.eurohub.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.github.wemilli.eurohub.model.Cargo;
import com.github.wemilli.eurohub.model.Colaborador;
import com.github.wemilli.eurohub.model.StatusColaborador;

public class ColaboradorRequestCreate {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Long cargoId;
    private LocalDate dataAdmissao;
    private StatusColaborador status;

    public Colaborador toModel(Cargo cargo, LocalDateTime now) {
        Colaborador colaborador = new Colaborador();
        colaborador.setNome(nome);
        colaborador.setCpf(cpf);
        colaborador.setTelefone(telefone);
        colaborador.setEmail(email);
        colaborador.setCargo(cargo);
        colaborador.setDataAdmissao(dataAdmissao);
        colaborador.setStatus(status);
        colaborador.setCreatedAt(now);
        colaborador.setUpdatedAt(now);
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

    public void setCargoId(Long idCargo) {
        this.cargoId = idCargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public StatusColaborador getStatus() {
        return status;
    }

    public void setStatus(StatusColaborador status) {
        this.status = status;
    }
}
