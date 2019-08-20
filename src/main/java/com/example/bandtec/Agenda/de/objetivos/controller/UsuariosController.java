package com.example.bandtec.Agenda.de.objetivos.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UsuariosController {
	
	private List<Usuario> usuarios;
	
	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome){
		List<Usuario> usuariosPorNome = new ArrayList<Usuario>();
		for (Usuario u : usuarios) {
			if(u.getNome().toLowerCase().equals(nome.toLowerCase())) {
				usuariosPorNome.add(u);
			}
		}
			if(usuariosPorNome.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		return ResponseEntity.ok(usuariosPorNome);
	}
	
	@GetMapping("/usuarios/idade/{idadePorUsuario}")
	public ResponseEntity<List<Usuario>> obterPoridade(@PathVariable("idadePorUsuario") Integer idade){
		List<Usuario> idadePorUsuario = new ArrayList<Usuario>();
		for (Usuario u : usuarios) {
			if(u.getIdade() == idade) {
				idadePorUsuario.add(u);
			}
		}
			if(idadePorUsuario.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		return ResponseEntity.ok(idadePorUsuario);
	}
	



	private  List<Usuario> obterTodosUsuarios(){
		return Arrays.asList(
				new Usuario("RODRIGO",39),
				new Usuario("rodrigo",30),
				new Usuario("michelle",19)
				);
	}
	
	}
	
	




