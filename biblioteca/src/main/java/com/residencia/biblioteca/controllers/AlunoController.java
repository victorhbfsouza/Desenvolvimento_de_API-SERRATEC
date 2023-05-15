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

import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@GetMapping	
	public ResponseEntity<List<Aluno>>  getAllAlunos(){
		return new ResponseEntity<>(alunoService.getAllAlunos(),
				HttpStatus.OK);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Integer id) {
		
		Aluno alunoResponse = alunoService.getAlunoById(id);
		if(alunoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(alunoResponse,
					HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
		
		return new ResponseEntity<>(alunoService.saveAluno(aluno),
				HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Aluno> updateAluno(@RequestBody Aluno aluno, Integer id) {
		
		return new ResponseEntity<> (alunoService.updateAluno(aluno, id),
				HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Boolean> deleteAluno(@PathVariable Integer id) {
		
		if(alunoService.delAluno(id) == false)
			return new ResponseEntity<>(false,
					HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<>(alunoService.delAluno(id),
					HttpStatus.OK);		
	}
}