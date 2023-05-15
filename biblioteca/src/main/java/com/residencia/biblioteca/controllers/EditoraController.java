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
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.services.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {
	
	@Autowired
	EditoraService editoraService;
	
	@GetMapping	
	public ResponseEntity<List<Editora>>  getAllEditoras(){
		return new ResponseEntity<>(editoraService.getAllEditoras(),
				HttpStatus.OK);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Editora> getEditoraById(@PathVariable Integer id) {
		
		Editora editoraResponse = editoraService.getEditoraById(id);
		if(editoraResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(editoraResponse,
					HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Editora> saveEditora(@RequestBody Editora editora) {
		
		return new ResponseEntity<>(editoraService.saveEditora(editora),
				HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Editora> updateEditora(@RequestBody Editora editora, Integer id) {
		
		return new ResponseEntity<> (editoraService.updateEditora(editora, id),
				HttpStatus.OK);
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<Boolean> deleteEditora(@PathVariable Integer id) {
		
		if(editoraService.delEditora(id) == false)
			return new ResponseEntity<>(false,
					HttpStatus.NOT_MODIFIED);
		else
			return new ResponseEntity<>(editoraService.delEditora(id),
					HttpStatus.OK);		
	}
}
