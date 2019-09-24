 package com.example.bandtec.Agenda.de.objetivos.Model;


 import javax.persistence.Embeddable;

 @Embeddable
public class Credenciais {

	private String login;
	private String senha;
	
	public Credenciais(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public String getLogin() {
		return login;
	}

	public Credenciais(){}
}
