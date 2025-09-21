package com.github.wemilli.eurohub.model;

public enum StatusIdeia {
    ANALISE ("Ideia em analise"),
    RECUSADA ("Ideia recusada"),
    APROVADA ("Ideia aprovada");

    StatusIdeia (String mensagem) {
        this.mensagem = mensagem;
    }

    private String mensagem;

    public String getMensagem () {
        return mensagem;
    }
}
