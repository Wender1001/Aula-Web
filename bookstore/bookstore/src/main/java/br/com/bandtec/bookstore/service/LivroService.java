package br.com.bandtec.bookstore.service;

import br.com.bandtec.bookstore.domain.Livro;
import br.com.bandtec.bookstore.domain.Opiniao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LivroService {

    private List<Opiniao> opinioes = new ArrayList<Opiniao>();
    private List<Livro> livros;

    public List<Livro> buscaPorTema(String tema){
        List<Livro> resultados = new ArrayList<Livro>();
        for(Livro livro : todosLivros()){
            if(livro.comTema(tema)){
                resultados.add(livro);
            }
        }
        return resultados;
    }



    private List <Livro>  todosLivros() {

        List<Livro> livros = new ArrayList<Livro>();
        livros.add( new Livro("50 tons de preto","comedia"));
        livros.add( new Livro("50 tons de amarelo","romance"));
        livros.add( new Livro("50 tons de azul","romance"));
        livros.add( new Livro("50 tons de cinza","comedia"));

        return livros;

    }


        public void adicionarOpiniao(Opiniao opiniao) {
        opinioes.add(opiniao);
    }
}
