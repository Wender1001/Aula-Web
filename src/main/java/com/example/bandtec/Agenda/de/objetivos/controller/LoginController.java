package com.example.bandtec.Agenda.de.objetivos.controller;

import com.example.bandtec.Agenda.de.objetivos.Model.Credenciais;
import com.example.bandtec.Agenda.de.objetivos.Repository.TodosUsuarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

	private TodosUsuarios todosUsuarios;

	public LoginController(TodosUsuarios todosUsuarios){
		this.todosUsuarios = todosUsuarios;
	}

		@GetMapping("/credenciais/login/{login}/{senha}")
		public ResponseEntity <List<Credenciais>> obterUsuario(@PathVariable("login")String login,
															   @PathVariable("senha") String senha){
			List <Credenciais> usuarios =  todosUsuarios.usuarioExiste( login,senha);
			if(usuarios.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok().body(usuarios);

	}

	@PostMapping("/credenciais")
	public ResponseEntity<String> salvo(@RequestBody Credenciais credenciais) {
		todosUsuarios.save(credenciais);
		return ResponseEntity.ok("sucesso");
	}


}


