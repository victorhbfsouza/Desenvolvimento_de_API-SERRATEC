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
	public ResponseEntity<List<Emprestimo>>  getAllEmprestimos(){
		return new ResponseEntity<>(emprestimoService.getAllEmprestimos(),
				HttpStatus.OK);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Emprestimo> getEmprestimoById(@PathVariable Integer id) {
		
		Emprestimo emprestimoResponse = emprestimoService.getEmprestimoById(id);
		if(emprestimoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(emprestimoResponse,
					HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> saveEmprestimo(@RequestBody Emprestimo emprestimo) {
		
		return new ResponseEntity<>(emprestimoService.saveEmprestimo(emprestimo),
				HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Emprestimo> updateEmprestimo(@RequestBody Emprestimo emprestimo, Integer id) {
		
		return new ResponseEntity<> (emprestimoService.updateEmprestimo(emprestimo, id),
				HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Boolean> deleteEmprestimo(@PathVariable Integer id) {
		
		if(emprestimoService.delEmprestimo(id) == false)
			return new ResponseEntity<>(false,
					HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<>(emprestimoService.delEmprestimo(id),
					HttpStatus.OK);		
	}
}
