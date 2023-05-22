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

import com.residencia.biblioteca.dto.AlunoDTO;
import com.residencia.biblioteca.dto.AlunoResumidoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> getAllAlunos() {
		List<Aluno> alunoResponse = alunoService.getAllAlunos();
		if(alunoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(alunoResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Integer id) {
		Aluno alunoResponse = alunoService.getAlunoById(id);
		if(alunoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(alunoResponse, HttpStatus.OK);
	}
	/*
	//Feito poe mim
	@GetMapping("/dto/{id}")
	public ResponseEntity<AlunoResumidoDTO> getAlunoDTOById(@PathVariable Integer id) {
		AlunoResumidoDTO alunoDTOResponse = alunoService.getAlunoDTOById(id);
		if(alunoDTOResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(alunoDTOResponse, HttpStatus.OK);
	}
	*/
	
	@GetMapping("/emprestimos/{id}")
	public ResponseEntity<AlunoResumidoDTO> getAlunoEmprestimosDTO(@PathVariable Integer id) {
		AlunoResumidoDTO alunoDTOResponse = alunoService.getAlunoEmprestimosDTO(id);
		if(alunoDTOResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(alunoDTOResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
		Aluno alunoResponse = alunoService.saveAluno(aluno);
		return new ResponseEntity<>(alunoResponse, HttpStatus.CREATED);
	}
	
	/*
	// Eu quem fiz
	 @PostMapping("/alunoDTO")
	public ResponseEntity<AlunoDTO> saveAlunoDTO(@RequestBody AlunoDTO alunoDTO) {
		AlunoDTO alunoResponse = alunoService.saveAlunoDTO(alunoDTO);
		return new ResponseEntity<>(alunoResponse, HttpStatus.CREATED);
	} 
	*/
	
	@PostMapping("/alunoDTO")
	public ResponseEntity<AlunoDTO> saveAlunoDTO(@RequestBody AlunoDTO alunoDTO) {
		AlunoDTO alunoResponse = alunoService.saveAlunoDTO(alunoDTO);
		if (alunoResponse == null)
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(alunoResponse, HttpStatus.CREATED);
	}
	
	// @PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<Aluno> updateAluno(@RequestBody Aluno aluno, @PathVariable Integer id) {
		//Aluno alunoGet = alunoService.getAlunoById(id);
		Aluno alunoResponse = alunoService.updateAluno(aluno, id);
		//if(alunoGet == null) 
			//return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		//else
			return new ResponseEntity<>(alunoResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delAluno(@PathVariable Integer id) {
		Boolean alunoResponse = alunoService.delAluno(id);
		if(alunoResponse)
			return new ResponseEntity<>(alunoResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(alunoResponse, HttpStatus.NOT_MODIFIED);
	}
}
