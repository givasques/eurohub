package com.github.wemilli.eurohub.model;

public enum StatusGestor {
    ATIVO ("Gestor ativo"),
    INATIVO ("Gestor inativo"),
    AFASTADO ("Gestor afastado"),
    FERIAS ("Gestor de ferias");

    StatusGestor (String mensagem) {
        this.mensagem = mensagem;
    }

    private String mensagem;

    public String getMensagem () {
        return mensagem;
    }
}
