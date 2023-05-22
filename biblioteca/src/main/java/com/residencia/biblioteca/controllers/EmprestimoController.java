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

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	@Autowired
	EmprestimoService emprestimoService;
	
	@GetMapping
	public ResponseEntity<List<Emprestimo>> getAllEmprestimos() {
		List<Emprestimo> emprestimoResponse = emprestimoService.getAllEmprestimos();
		if(emprestimoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(emprestimoResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> getEmprestimoById(@PathVariable Integer id) {
		Emprestimo emprestimoResponse = emprestimoService.getEmprestimoById(id);
		if(emprestimoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(emprestimoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> saveEmprestimo(@RequestBody Emprestimo emprestimo) {
		Emprestimo emprestimoResponse = emprestimoService.saveEmprestimo(emprestimo);
		return new ResponseEntity<>(emprestimoResponse, HttpStatus.CREATED);
	}
	
	//@PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<Emprestimo> updateEmprestimo(@RequestBody Emprestimo emprestimo, @PathVariable Integer id) {
		//Emprestimo emprestimoGet = emprestimoService.getEmprestimoById(id);
		Emprestimo emprestimoResponse = emprestimoService.updateEmprestimo(emprestimo, id);
		//if(emprestimoGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(emprestimoResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delEmprestimo(@PathVariable Integer id) {
		Boolean emprestimoResponse = emprestimoService.delEmprestimo(id);
		if(emprestimoResponse)
			return new ResponseEntity<>(emprestimoResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(emprestimoResponse, HttpStatus.NOT_MODIFIED);
	}
}
