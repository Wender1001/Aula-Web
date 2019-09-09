package com.example.bandtec.Agenda.de.objetivos.controller;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface TodosObjetivos  extends JpaRepository<Objetivo, Integer> {

	public void save(Objetivo objetivo);

	public List<Objetivo> ate(LocalDate data);

}
