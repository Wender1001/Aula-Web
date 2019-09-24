package com.example.bandtec.Agenda.de.objetivos.controller;

import com.example.bandtec.Agenda.de.objetivos.Model.Credenciais;
import com.example.bandtec.Agenda.de.objetivos.Repository.TodosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController  {

	private TodosUsuarios todosUsuarios;

	@Autowired
	public LoginController(TodosUsuarios todosUsuarios){
		this.todosUsuarios = todosUsuarios;
	}


	@PostMapping("/login")
	public ResponseEntity<String> salvo(@RequestBody Credenciais credenciais) {
		if(todosUsuarios.usuarioExiste(credenciais)== null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("falso");

		}
		return ResponseEntity.ok("sucesso");

	}
}


