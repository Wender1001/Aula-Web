package br.com.bandtec.bookstore.controller;

import br.com.bandtec.bookstore.domain.Livro;
import br.com.bandtec.bookstore.domain.Opiniao;
import br.com.bandtec.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivroController {

    private LivroService service;
//wender
    @Autowired
     public LivroController(LivroService service){
         this.service = service;
     }

     @GetMapping("/livros/tema/{tema}")
     public ResponseEntity<List<Livro>>obterPorTema(
        @PathVariable("tema") String tema){
        List<Livro> livtos = service.buscaPorTema(tema);
        if(livtos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livtos);
     }

     @PostMapping("/livros/opinar")
    public ResponseEntity<String> opinar(@RequestBody Opiniao opiniao){
        service.adicionarOpiniao( opiniao);
        return ResponseEntity.ok("Opiniao enviada");
     }
}

