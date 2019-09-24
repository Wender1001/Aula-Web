package com.example.bandtec.Agenda.de.objetivos.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "objetivos")
public class Objetivo {


@Embedded
@JsonProperty
private Credenciais credenciais;

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

	private Prioridade prioridade;

	public Objetivo() {}
	
	public Objetivo(String titulo, String descricao, LocalDate dataMaximaParaExecucao,Prioridade prioridade) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataMaximaParaExecucao = dataMaximaParaExecucao;
		this.prioridade = prioridade;
	}

	@Override
	public String toString() {
		return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
				+ dataMaximaParaExecucao + "]";
	}

	public boolean ate(LocalDate data) {
		return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
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
