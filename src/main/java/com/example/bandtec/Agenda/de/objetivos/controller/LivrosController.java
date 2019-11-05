package com.example.bandtec.Agenda.de.objetivos.controller;

import com.example.bandtec.Agenda.de.objetivos.Model.Livro;
import com.example.bandtec.Agenda.de.objetivos.Service.Livraria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivrosController {

    private Livraria service;

    @Autowired
    public LivrosController(Livraria service){
        this.service = service;
    }

    @GetMapping("/livros/tema/{tema}")
    public ResponseEntity<List<Livro>>buscaPorTema(
            @PathVariable("tema") String tema){
        List<Livro> livros = service.buscarPorTema(tema);
        if(livros.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }



}
