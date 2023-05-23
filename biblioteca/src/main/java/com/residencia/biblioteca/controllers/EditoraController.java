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
		return new ResponseEntity<>(editoraService.getAllEditoras(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora> getEditoraById(@PathVariable Integer id) {
		//return editoraService.getEditoraById(id);
		Editora editoraResponse = editoraService.getEditoraById(id);
		if(null == editoraResponse)
			return new ResponseEntity<>(null,
					HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(editoraResponse,
					HttpStatus.OK);
			
	}
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<EditoraResumidaDTO> getEditoraDtoById(@PathVariable Integer id) {

		EditoraResumidaDTO editoraDtoResponse = editoraService.getEditoraDtoById(id);
		if(null == editoraDtoResponse)
			return new ResponseEntity<>(null,
					HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(editoraDtoResponse,
					HttpStatus.OK);
			
	}
	
	@PostMapping
	public ResponseEntity<Editora> saveEditora(@RequestBody Editora editora) {
		return new ResponseEntity<>(editoraService.saveEditora(editora),
				HttpStatus.CREATED);
	}
	
	@PostMapping("/dto")
	public ResponseEntity<EditoraResumidaDTO> saveEditoraDto(
			@RequestBody EditoraResumidaDTO editoraResumidaDto) {
		
		return new ResponseEntity<>(editoraService.saveEditoraDto(editoraResumidaDto),
				HttpStatus.CREATED);
	}
	
	@PutMapping
	//@PutMapping("/{id}")
	public ResponseEntity<Editora> updateEditora(@RequestBody Editora editora, Integer id) {
		return new ResponseEntity<>(editoraService.updateEditora(editora, id),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delEditora(@PathVariable Integer id) {
		Boolean resp = editoraService.delEditora(id);
		if(resp)
			return new ResponseEntity<>(resp, HttpStatus.OK);
		else
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
	}
}
