package com.example.bandtec.Agenda.de.objetivos.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Livro {
    @JsonProperty
    private String nome;
    @JsonProperty
    private String tema;

    public Livro(String nome, String tema) {
        this.nome = nome;
        this.tema = tema;
    }
}
