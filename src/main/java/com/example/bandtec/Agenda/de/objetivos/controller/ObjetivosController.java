package com.example.bandtec.Agenda.de.objetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ObjetivosController {


    private TodosObjetivos todosObjetivos;

    public ObjetivosController(TodosObjetivos todosObjetivos){
        this.todosObjetivos = todosObjetivos;
    }

    @GetMapping("/objetivos/data/{data}")
    public ResponseEntity<List<Objetivo>> obterPorData(@PathVariable("data") String data){
       return ResponseEntity.ok().body(todosObjetivos.ate(LocalDate.parse(data)));

}
    @PostMapping("/objetivos")
    public ResponseEntity<Objetivo> salvar(@RequestBody Objetivo objetivo) {
        todosObjetivos.salvar(objetivo);
        return ResponseEntity.ok().body(objetivo);
    }


}

