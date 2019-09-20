package com.example.bandtec.Agenda.de.objetivos.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "objetivos")
public class Objetivo {



	@JsonProperty
	private String titulo;
	
	@JsonProperty
	private String descricao;

	@Column(name = "data_maxima_para_execucao")
	@JsonProperty
	private LocalDate dataMaximaParaExecucao;

	@Id
	@GeneratedValue
	private long id;
	
	public Objetivo() {}
	
	public Objetivo(String titulo, String descricao, LocalDate dataMaximaParaExecucao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
	}

	@Override
	public String toString() {
		return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
				+ dataMaximaParaExecucao + "]";
	}

	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}

	/*
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataMaximaParaExecucao() {
		return dataMaximaParaExecucao;
	}*/
}
