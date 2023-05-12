package com.residencia.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity <List<Aluno>> getAllAlunos() {
		return  new ResponseEntity <> (alunoService.getAllAlunos(),
				HttpStatus.OK);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity <Aluno> getAlunoById(Integer id) {
		//return alunoService.getAlunoById(id);
		Aluno alunoResponse = alunoService.getAlunoById(id);
		if(null == alunoResponse)
			return new ResponseEntity<>(null,
					HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(alunoResponse,
					HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> saveAluno(Aluno aluno) {
		return new ResponseEntity<>{alunoService.saveAluno(aluno),
			HttpStatus.CREATED);
		}
	}
	
	@PutMapping
	//@PutMapping ("/{id}")
	public ResponseEntity<Aluno> updateAluno(Aluno aluno, Integer id) {
		return new ResponseEntity<> (alunoService.updateAluno(aluno, id),
			HttpStatus.OK);
	}
	
		@DeleteMapping ("/{id}")
	public ResponseEntity <Boolean> delAluno(Integer id) {
		Boolean resp = alunoService.delAluno(id);
		if (resp)
			return new ResponseEntity<>(resp, HttpStatus.OK);
		else
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
	}
}
