package com.example.bandtec.Agenda.de.objetivos.controller;

import com.example.bandtec.Agenda.de.objetivos.Model.Objetivo;
import com.example.bandtec.Agenda.de.objetivos.Repository.TodosObjetivos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ObjetivosController {


    private TodosObjetivos todosObjetivos;

    public ObjetivosController(TodosObjetivos todosObjetivos){
        this.todosObjetivos = todosObjetivos;
    }

    @GetMapping("/objetivos/data/{data}")
    public ResponseEntity<List<Objetivo>> obterPorData(@PathVariable("data") String data){

       List <Objetivo> objetivos =  todosObjetivos.ate(LocalDate.parse(data));
        if(objetivos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok().body(objetivos);


}
//    @PostMapping("/objetivos")
//    public ResponseEntity<String> salvar(@RequestBody Objetivo objetivo) {
//        todosObjetivos.save(objetivo);
//        return ResponseEntity.ok("sucesso");
//    }


}

