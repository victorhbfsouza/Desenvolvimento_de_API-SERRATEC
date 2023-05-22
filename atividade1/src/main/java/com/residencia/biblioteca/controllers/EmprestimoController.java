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

import com.residencia.biblioteca.dto.EmprestimoResumidoDTO;
import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	@Autowired
	EmprestimoService EmprestimoService;
	
	@GetMapping
	public ResponseEntity<List<Emprestimo>> getAllEmprestimos() {
		return new ResponseEntity<>(EmprestimoService.getAllEmprestimo(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> getEmprestimoById(@PathVariable Integer id) {
		
		Emprestimo EmprestimoResponse = EmprestimoService.getEmprestimoById(id);
		
		if(EmprestimoResponse == null) {
			return new ResponseEntity<>(null,
					HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(EmprestimoResponse,
					HttpStatus.OK);
		}
	}
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<EmprestimoResumidoDTO> getEmprestimoDTOById(@PathVariable Integer id) {
		
		EmprestimoResumidoDTO EmprestimoResponse = EmprestimoService.getEmprestimoDTOById(id);
		
		if(EmprestimoResponse == null) {
			return new ResponseEntity<>(null,
					HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(EmprestimoResponse,
					HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> saveEmprestimo(@RequestBody Emprestimo Emprestimo) {
		return new ResponseEntity<>(EmprestimoService.saveEmprestimo(Emprestimo), 
				HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Emprestimo> updateEmprestimo(@RequestBody Emprestimo Emprestimo, Integer id) {
		return new ResponseEntity<>(EmprestimoService.updateEmprestimo(Emprestimo, id),
				HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEmprestimo(@PathVariable Integer id) {
		Boolean emprestimoDeletado =  EmprestimoService.deleteEmprestimo(id);
		
		if(emprestimoDeletado) {
			return new ResponseEntity<>( emprestimoDeletado, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(emprestimoDeletado, HttpStatus.NOT_MODIFIED);
 		}
		
	}
}
