package com.residencia.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.biblioteca.entities.Usuario;
import com.residencia.biblioteca.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		List<Usuario> usuarioResponse = usuarioService.getAllUsuarios();
		if(usuarioResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
		Usuario usuarioResponse = usuarioService.getUsuarioById(id);
		if(usuarioResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioResponse = usuarioService.saveUsuario(usuario);
		return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
	}
	
	//@PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
		//Usuario usuarioGet = usuarioService.getUsuarioById(id);
		Usuario usuarioResponse = usuarioService.updateUsuario(usuario, id);
		//if(usuarioGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(usuarioResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delUsuario(@PathVariable Integer id) {
		Boolean usuarioResponse = usuarioService.delUsuario(id);
		if(usuarioResponse)
			return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(usuarioResponse, HttpStatus.NOT_MODIFIED);
	}
}
