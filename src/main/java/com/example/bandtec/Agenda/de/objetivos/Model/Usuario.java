package com.example.bandtec.Agenda.de.objetivos.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;

	@JsonProperty
	private String nome;
	@JsonProperty
	private Integer idade;

	@Embedded
	@JsonProperty
	private Credenciais credenciais;
	
	public Usuario(String nome, Integer idade, Credenciais credenciais ){
	this.nome = nome;
	this.idade = idade;
	this.credenciais = credenciais;
	
}

	public Usuario(){}

}
