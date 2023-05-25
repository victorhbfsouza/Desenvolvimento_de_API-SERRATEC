package com.grupo5.ecommerce.controllers;

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

import com.grupo5.ecommerce.entities.Categoria;
import com.grupo5.ecommerce.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
		
		@Autowired
		CategoriaService categoriaService;
		
		@GetMapping
		public ResponseEntity<List<Categoria>> getAllCategorias() {
			return new ResponseEntity<>(categoriaService.getAllCategorias(),HttpStatus.OK);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id) {
			//return categoriaService.getCategoriaById(id);
			Categoria categoriaResponse = categoriaService.getCategoriaById(id);
			if(null == categoriaResponse) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
			}
		}
		
		@PostMapping
		public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
			return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.CREATED);
		}
		
		@PutMapping (value = "/{id}")
		//@PutMapping(value = "/{id}")
		public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, Integer id) {
			return new ResponseEntity<>(categoriaService.updateCategoria(categoria, id), HttpStatus.OK);
		}
		
		@DeleteMapping(value = "/{id}")
			public ResponseEntity<Boolean> delCategoria(@PathVariable Integer id) {
			//return categoriaService.delCategoria(id);
			Boolean resp = categoriaService.delCategoria(id);
			if(resp) {
				return new ResponseEntity<>(resp, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
			}	
		}
	}
