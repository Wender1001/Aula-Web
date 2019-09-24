package com.example.bandtec.Agenda.de.objetivos.Repository;

import com.example.bandtec.Agenda.de.objetivos.Model.Credenciais;
import com.example.bandtec.Agenda.de.objetivos.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosUsuarios extends JpaRepository<Usuario, Long> {

    @Query("select o from Usuario o where o.credenciais = :credenciais")
    public Usuario usuarioExiste(
            @Param("credenciais")Credenciais credenciais);

}
