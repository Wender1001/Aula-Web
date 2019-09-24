package com.example.bandtec.Agenda.de.objetivos.controller;

import com.example.bandtec.Agenda.de.objetivos.Model.Credenciais;
import com.example.bandtec.Agenda.de.objetivos.Repository.TodosUsuarios;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class LoginControllerTest {

	private LoginController controller;

	private TodosUsuarios todosUsuarios;


	@Before
	public void setup() {

		todosUsuarios = Mockito.mock(TodosUsuarios.class);
		controller = new LoginController(todosUsuarios);

	}

	@Test

	public void loginComSucesso(){

		ResponseEntity<String> resposta = controller.salvo(new Credenciais("igual","igual"));
		assertEquals(HttpStatus.OK,resposta.getStatusCode());
		assertEquals("sucesso", resposta.getBody());
	}

	@Test

	public void loginComFalha(){

		ResponseEntity<String> resposta = controller.salvo(new Credenciais("login","senha"));

		assertEquals(HttpStatus.UNAUTHORIZED,resposta.getStatusCode());
		assertEquals("erro", resposta.getBody());


	}
}
