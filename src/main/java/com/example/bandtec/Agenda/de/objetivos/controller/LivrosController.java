package com.example.bandtec.Agenda.de.objetivos.controller;

import com.example.bandtec.Agenda.de.objetivos.Model.Livro;
import com.example.bandtec.Agenda.de.objetivos.Model.Opiniao;
import com.example.bandtec.Agenda.de.objetivos.Service.Livraria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivrosController {

    private final Livraria livrariaService;

    @Autowired
    public LivrosController(Livraria service){
        this.livrariaService = service;
    }

    @GetMapping("/livros/tema/{tema}")
    public ResponseEntity<List<Livro>>buscaPorTema(
            @PathVariable("tema") String tema){
        List<Livro> livros = livrariaService.buscarPorTema(tema);
        if(livros.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }

    @PostMapping("/livros/opinar")
    public ResponseEntity<String> opinar(@RequestBody Opiniao opiniao){
      String resposta =  livrariaService.adicionaOpiniao(opiniao);
        return ResponseEntity.ok(resposta);
    }


}
