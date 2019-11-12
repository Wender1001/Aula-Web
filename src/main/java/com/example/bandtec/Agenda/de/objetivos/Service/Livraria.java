package com.example.bandtec.Agenda.de.objetivos.Service;


import com.example.bandtec.Agenda.de.objetivos.Model.Livro;
import com.example.bandtec.Agenda.de.objetivos.Model.Opiniao;
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

    String url = "http://localhost:8081/livros/";

    public List<Livro> buscarPorTema(String tema){
        String urlBusca = url + tema;
        ResponseEntity<List> resposta =
                restTemplate.getForEntity(urlBusca,List.class);

        return  resposta.getBody();
    }

    public  String adicionaOpiniao(Opiniao opiniao){

        String urlCadastro = url + "/opinar";
        ResponseEntity<String> resposta =
                restTemplate.postForEntity(urlCadastro,opiniao,String.class);

        return  resposta.getBody();
    }

}
