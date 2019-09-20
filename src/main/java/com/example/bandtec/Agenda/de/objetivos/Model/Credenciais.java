package com.example.bandtec.Agenda.de.objetivos.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "usuarios")
public class Credenciais {

	@Id
	@GeneratedValue
	private long id;

	@JsonProperty
	private String login;

	@JsonProperty
	private String senha;
	
	public Credenciais(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Credenciais() {}


	@Override
	public String toString() {
		return "Credenciais{" +
				"login='" + login + '\'' +
				", senha='" + senha + '\'' +
				'}';
	}
	public boolean usuarioExiste(String login, String senha) {
		return login.equals(login) && senha.equals(senha);
	}
}
