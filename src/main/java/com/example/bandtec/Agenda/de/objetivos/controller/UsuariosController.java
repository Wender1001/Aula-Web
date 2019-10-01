package com.example.bandtec.Agenda.de.objetivos.controller;

import com.example.bandtec.Agenda.de.objetivos.Model.Usuario;
import com.example.bandtec.Agenda.de.objetivos.Repository.TodosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UsuariosController {

	private TodosUsuarios todosUsuarios;
	
	@Autowired
	public UsuariosController(TodosUsuarios todosUsuarios){
		this.todosUsuarios = todosUsuarios;
	}

	@GetMapping("/usuarios/nome/{nome}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nome") String nome){
	List<Usuario> usuarios = todosUsuarios.porNome(nome);
	if(usuarios.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/usuarios/idade/{idade}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idade") Integer idade){
		List<Usuario> usuarios = todosUsuarios.porIdade(idade);
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/usuarios")
	public  ResponseEntity<List<Usuario>> obterUsuarios(){
		return ResponseEntity.ok(todosUsuarios.findAll());
	}

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.ok(todosUsuarios.save(usuario));
	}
	
	}