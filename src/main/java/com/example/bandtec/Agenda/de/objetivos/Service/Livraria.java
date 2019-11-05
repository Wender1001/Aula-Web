package com.example.bandtec.Agenda.de.objetivos.Service;


import com.example.bandtec.Agenda.de.objetivos.Model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class Livraria {

    private RestTemplate restTemplate;

    public Livraria() {
        this.restTemplate =  new RestTemplate();
    }

    public List<Livro> buscarPorTema(String tema){
        String url = "http://localhost:8081/livros/tema/";
        String urlBusca = url + tema;
        ResponseEntity<List> resposta =
                restTemplate.getForEntity(urlBusca,List.class);

        return  resposta.getBody();
    }

}
