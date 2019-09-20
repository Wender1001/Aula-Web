package com.example.bandtec.Agenda.de.objetivos.controller;


import java.util.ArrayList;
import java.util.List;

import com.example.bandtec.Agenda.de.objetivos.Model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UsuariosController {
	
	private List<Usuario> usuarios;
	
	public UsuariosController() { this.usuarios = obterTodosUsuarios(); }

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
	
	@GetMapping("/usuarios/todos")
	public ResponseEntity<List<Usuario>> obterTodos(){
		List<Usuario> todosUsuarios = new ArrayList<Usuario>();
			for (Usuario u : usuarios) {
				todosUsuarios.add(u);
		}
			if(todosUsuarios.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		return ResponseEntity.ok(todosUsuarios);
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
		ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
				Usuarios.add(new Usuario("wender",39));
				Usuarios.add(new Usuario("rodrigo",30));
				Usuarios.add(new Usuario("michelle",19));
				return Usuarios;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		this.usuarios.add(usuario);
		return ResponseEntity.ok().body(usuario);
	}
	
	}
	
	




