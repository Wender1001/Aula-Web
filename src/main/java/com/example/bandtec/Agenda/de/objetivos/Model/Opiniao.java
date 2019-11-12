package com.example.bandtec.Agenda.de.objetivos.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Opiniao {

    @JsonProperty
    private String nome;
    @JsonProperty
    private String texto;

    public Opiniao(String nome, String texto) {
        this.nome = nome;
        this.texto = texto;
    }

}
