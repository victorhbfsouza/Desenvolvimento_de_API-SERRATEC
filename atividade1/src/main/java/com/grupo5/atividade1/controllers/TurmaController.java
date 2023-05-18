package com.grupo5.atividade1.controllers;

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

import com.grupo5.atividade1.entities.Turma;
import com.grupo5.atividade1.services.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	TurmaService turmaService;
	
	@GetMapping	
	public ResponseEntity<List<Turma>>  getAllTurmas(){
		return new ResponseEntity<>(turmaService.getAllTurmas(),
				HttpStatus.OK);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Turma> getTurmaById(@PathVariable Integer id) {
		
		Turma turmaResponse = turmaService.getTurmaById(id);
		if(turmaResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(turmaResponse,
					HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
		
		return new ResponseEntity<>(turmaService.saveTurma(turma),
				HttpStatus.CREATED);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Turma> updateTurma(@RequestBody Turma turma, @PathVariable Integer id) {
		
		return new ResponseEntity<> (turmaService.updateTurma (turma, id),
				HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Boolean> deleteTurma(@PathVariable Integer id) {
		
		if(turmaService.delTurma(id) == false)
			return new ResponseEntity<>(false,
					HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<>(turmaService.delTurma(id),
					HttpStatus.OK);		
	}
}
