package com.example.bandtec.Agenda.de.objetivos.Repository;

import com.example.bandtec.Agenda.de.objetivos.Model.Credenciais;
import com.example.bandtec.Agenda.de.objetivos.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {

    @Query("select o from Usuario o where o.credenciais = :credenciais")
    public Usuario usuarioExiste(
            @Param("credenciais")Credenciais credenciais);

    @Query("from Usuario where nome = :nome")
    public List<Usuario> porNome(@Param("nome") String nome);

    @Query("from Usuario where idade = :idade")
    public List<Usuario> porIdade(@Param("idade") Integer idade);

}
