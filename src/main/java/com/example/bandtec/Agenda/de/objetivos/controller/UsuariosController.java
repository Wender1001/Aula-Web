package com.example.bandtec.Agenda.de.objetivos.controller;


import com.example.bandtec.Agenda.de.objetivos.Model.Usuario;
import com.example.bandtec.Agenda.de.objetivos.Repository.TodosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UsuariosController {

	private TodosUsuarios todosUsuarios;
	
	@Autowired
	public UsuariosController(TodosUsuarios todosUsuarios){
		this.todosUsuarios = todosUsuarios;
	}

//	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
//	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nome){
//		List<Usuario> usuariosPorNome = new ArrayList<Usuario>();
//		for (Usuario u : usuarios) {
//			if(u.getNome().toLowerCase().equals(nome.toLowerCase())) {
//				usuariosPorNome.add(u);
//			}
//		}
//			if(usuariosPorNome.isEmpty()) {
//				return ResponseEntity.noContent().build();
//			}
//		return ResponseEntity.ok(usuariosPorNome);
//	}
	
	//@GetMapping("/usuarios/todos")
//	public ResponseEntity<List<Usuario>> obterTodos(){
//		List<Usuario> todosUsuarios = new ArrayList<Usuario>();
//			for (Usuario u : usuarios) {
//				todosUsuarios.add(u);
//		}
//			if(todosUsuarios.isEmpty()) {
//				return ResponseEntity.noContent().build();
//			}
//		return ResponseEntity.ok(todosUsuarios);
//	}
	
//	@GetMapping("/usuarios/idade/{idadePorUsuario}")
//	public ResponseEntity<List<Usuario>> obterPoridade(@PathVariable("idadePorUsuario") Integer idade){
//		List<Usuario> idadePorUsuario = new ArrayList<Usuario>();
//		for (Usuario u : usuarios) {
//			if(u.getIdade() == idade) {
//				idadePorUsuario.add(u);
//			}
//		}
//			if(idadePorUsuario.isEmpty()) {
//				return ResponseEntity.noContent().build();
//			}
//		return ResponseEntity.ok(idadePorUsuario);
//	}

	@GetMapping("/usuarios")
	public  ResponseEntity<List<Usuario>> obterUsuarios(){
		return ResponseEntity.ok(todosUsuarios.findAll());
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.ok(todosUsuarios.save(usuario));
	}
	
	}