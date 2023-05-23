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
import com.residencia.biblioteca.enums.StatusDeleteEnum;
import com.residencia.biblioteca.exception.AlunoNotFoundException;
import com.residencia.biblioteca.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> getAllAlunos() {
		return new ResponseEntity<>(alunoService.getAllAlunos(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Integer id) {
		return new ResponseEntity<>(alunoService.getAlunoById(id),
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}/emprestimos")
	public ResponseEntity<AlunoResumidoDTO> getAlunoEmprestimosDto(@PathVariable Integer id){
		AlunoResumidoDTO alunoResumidoDto = alunoService.getAlunoEmprestimosDto(id);
		if(null == alunoResumidoDto)
			return new ResponseEntity<>(null,
					HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(alunoResumidoDto,
					HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> saveAluno(@Valid @RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.saveAluno(aluno),
				HttpStatus.CREATED);
	}
	
	@PostMapping("/dto")
	public ResponseEntity<AlunoDTO> saveAlunoDto(@RequestBody AlunoDTO alunoDto) {
		return new ResponseEntity<>(alunoService.saveAlunoDto(alunoDto),
				HttpStatus.CREATED);
	}
	
	@PutMapping
	//@PutMapping("/{id}")
	public ResponseEntity<Aluno> updateAluno(@RequestBody Aluno aluno, Integer id) {
		return new ResponseEntity<>(alunoService.updateAluno(aluno, id),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<StatusDeleteEnum> delAluno(@PathVariable Integer id) {
		StatusDeleteEnum resp = alunoService.delAluno(id);
		if(resp == StatusDeleteEnum.NAO_ENCONTRADO)
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		else if(resp == StatusDeleteEnum.DELETADO)
			return new ResponseEntity<>(resp, HttpStatus.OK);
		else
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
	}
}
