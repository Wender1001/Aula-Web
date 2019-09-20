//package com.example.bandtec.Agenda.de.objetivos.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import com.example.bandtec.Agenda.de.objetivos.Model.Credenciais;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//public class LoginControllerTest {
//
//	private LoginController controller;
//
//
//	@Before
//	public void setup() {
//
//		LoginController controller ;
//
//	}
//
//	@Test
//
//	public void loginComSucesso(){
//
//
//
//		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("igual","igual"));
//
//		assertEquals(HttpStatus.OK,resposta.getStatusCode());
//		assertEquals("sucesso", resposta.getBody());
//	}
//
//	@Test
//
//	public void loginComFalha(){
//
//
//
//		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login","senha"));
//
//		assertEquals(HttpStatus.UNAUTHORIZED,resposta.getStatusCode());
//		assertEquals("erro", resposta.getBody());
//
//
//	}
//}
