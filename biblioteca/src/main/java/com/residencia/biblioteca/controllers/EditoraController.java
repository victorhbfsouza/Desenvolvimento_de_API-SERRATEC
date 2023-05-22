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

import com.residencia.biblioteca.dto.EditoraResumidaDTO;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.services.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {
	
	@Autowired
	EditoraService editoraService;
	
	@GetMapping
	public ResponseEntity<List<Editora>> getAllEditoras() {
		List<Editora> editoraResponse = editoraService.getAllEditoras();
		if(editoraResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(editoraResponse, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora> getEditoraById(@PathVariable Integer id) {
		Editora editoraResponse = editoraService.getEditoraById(id);
		if(editoraResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(editoraResponse, HttpStatus.OK);
	}
	
	//DTO
	@GetMapping("/dto/{id}")
	public ResponseEntity<EditoraResumidaDTO> getEditoraDtoById(@PathVariable Integer id) {
		//A editoraDTO recebe o valor de DTO
		EditoraResumidaDTO editoraDTOResponse = editoraService.getEditoraDTOById(id);
		if(editoraDTOResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(editoraDTOResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Editora> saveEditora(@RequestBody Editora editora) {
		Editora editoraResponse = editoraService.saveEditora(editora);
		return new ResponseEntity<>(editoraResponse, HttpStatus.CREATED);
	}
	
	//@PutMapping
	@PutMapping("/{id}") //Lembrete para quando voltar
	public ResponseEntity<Editora> updateEditora(@RequestBody Editora editora, Integer id) {
		Editora editoraGet = editoraService.getEditoraById(id);
		Editora editoraResponse = editoraService.updateEditora(editora, id);
		if(editoraGet == null) 
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED); 
		else
			return new ResponseEntity<>(editoraResponse, HttpStatus.OK); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delEditora(@PathVariable Integer id) {
		Boolean editoraResponse = editoraService.delEditora(id);
		if(editoraResponse)
			return new ResponseEntity<>(editoraResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(editoraResponse, HttpStatus.NOT_MODIFIED);
	}
}