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

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping
	public ResponseEntity<List<Livro>> getAllLivros() {
		List<Livro> livroResponse = livroService.getAllLivros();
		if(livroResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(livroResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> getLivroById(@PathVariable Integer id) {
		Livro livroResponse = livroService.getLivroById(id);
		if(livroResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(livroResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Livro> saveLivro(@RequestBody Livro livro) {
		Livro livroResponse = livroService.saveLivro(livro);
		return new ResponseEntity<>(livroResponse, HttpStatus.CREATED);
	}
	
	//@PutMapping
	@PutMapping("/{id}")
	public ResponseEntity<Livro> updateLivro(@RequestBody Livro livro, @PathVariable Integer id) {
		//Livro livroGet = livroService.getLivroById(id);
		Livro livroResponse = livroService.updateLivro(livro, id);
		//if(livroGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(livroResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delLivro(@PathVariable Integer id) {
		Boolean livroResponse = livroService.delLivro(id);
		if(livroResponse)
			return new ResponseEntity<>(livroResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(livroResponse, HttpStatus.NOT_MODIFIED);
	}
}
