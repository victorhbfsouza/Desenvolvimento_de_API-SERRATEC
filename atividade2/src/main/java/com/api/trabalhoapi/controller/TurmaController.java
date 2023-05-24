package com.api.trabalhoapi.controller;

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

import com.api.trabalhoapi.entities.Turma;
import com.api.trabalhoapi.services.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
	
	@Autowired
	TurmaService turmaService;
	
	@GetMapping
	public ResponseEntity<List<Turma>> getAllTurmas() {
		return new ResponseEntity<>(turmaService.getAllTurmas(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Turma> getTurmaById(@PathVariable Integer id) {
		//return turmaService.getTurmaById(id);
		Turma turmaResponse = turmaService.getTurmaById(id);
		if(null == turmaResponse) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(turmaResponse, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.saveTurma(turma), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	//@PutMapping(value = "/{id}")
	public ResponseEntity<Turma> updateTurma(@RequestBody Turma turma, Integer id) {
		return new ResponseEntity<>(turmaService.updateTurma(turma, id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
		public ResponseEntity<Boolean> delTurma(@PathVariable Integer id) {
		//return turmaService.delTurma(id);
		Boolean resp = turmaService.delTurma(id);
		if(resp) {
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}	
	}
}
