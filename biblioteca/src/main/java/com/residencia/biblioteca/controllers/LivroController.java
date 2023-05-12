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
	public ResponseEntity <List<Livro>> getAllLivros() {
		return  new ResponseEntity <> (livroService.getAllLivros(),
				HttpStatus.OK);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity <Livro> getLivroById(Integer id) {
		//return livroService.getLivroById(id);
		Livro livroResponse = livroService.getLivroById(id);
		if(null == livroResponse)
			return new ResponseEntity<>(null,
					HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(livroResponse,
					HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Livro> saveLivro(@RequestBody Livro livro) {
		return new ResponseEntity<>(livroService.saveLivro(livro),
			HttpStatus.CREATED);
	}
	
	@PutMapping
	//@PutMapping ("/{id}")
	public ResponseEntity<Livro> updateLivro(@RequestBody Livro livro, Integer id) {
		return new ResponseEntity<> (livroService.updateLivro(livro, id),
			HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <Boolean> delLivro(@PathVariable Integer id) {
		Boolean resp = livroService.delLivro(id);
		if (resp)
			return new ResponseEntity<>(resp, HttpStatus.OK);
		else
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
	}
}
