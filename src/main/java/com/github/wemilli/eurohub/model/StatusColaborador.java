package com.github.wemilli.eurohub.model;

public enum StatusColaborador {
    ATIVO ("Colaborador ativo"),
    INATIVO ("Colaborador inativo"),
    AFASTADO ("Colaborador afastado"),
    FERIAS ("Colaborador de ferias");

    StatusColaborador (String mensagem) {
        this.mensagem = mensagem;
    }

    private String mensagem;

    public String getMensagem () {
        return mensagem;
    }
}
