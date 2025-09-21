package com.github.wemilli.eurohub.model;

public enum StatusDesafio {
    ATIVO ("Desafio ativo"),
    INATIVO ("Desafio inativo");

    StatusDesafio (String mensagem) {
        this.mensagem = mensagem;
    }

    private String mensagem;

    public String getMensagem () {
        return mensagem;
    }
}
