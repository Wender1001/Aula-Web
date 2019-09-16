package com.example.bandtec.Agenda.de.objetivos.controller;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@Repository
public interface TodosObjetivos  extends JpaRepository<Objetivo, Long> {




	@Query("select o from Objetivo o where o.dataMaximaParaExecucao <= :data")
	public List<Objetivo> ate(@Param("data") LocalDate data);

}
