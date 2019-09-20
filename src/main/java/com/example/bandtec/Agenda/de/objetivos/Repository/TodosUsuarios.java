package com.example.bandtec.Agenda.de.objetivos.Repository;

import com.example.bandtec.Agenda.de.objetivos.Model.Credenciais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosUsuarios extends JpaRepository<Credenciais, Long> {

    @Query("select o from Credenciais o where o.login = :login and o.senha = :senha")
    public List<Credenciais>usuarioExiste(
            @Param("login")  String login,
            @Param("senha") String senha);

}
