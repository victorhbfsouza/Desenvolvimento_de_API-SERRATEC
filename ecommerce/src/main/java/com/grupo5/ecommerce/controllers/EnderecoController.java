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

import com.grupo5.ecommerce.entities.Endereco;
import com.grupo5.ecommerce.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> getAllEnderecos() {
		return new ResponseEntity<>(enderecoService.getAllEnderecos(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer id) {
		Endereco enderecoResponse = enderecoService.getEnderecoById(id);
		if(null == enderecoResponse) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(enderecoResponse, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) {
		return new ResponseEntity<>(enderecoService.saveEndereco(endereco), HttpStatus.CREATED);
	}
	
	@PutMapping (value = "/{id}")
	//@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> updateEndereco(@RequestBody Endereco endereco, Integer id) {
		return new ResponseEntity<>(enderecoService.updateEndereco(endereco, id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
		public ResponseEntity<Boolean> delEndereco(@PathVariable Integer id) {
		//return enderecoService.delEndereco(id);
		Boolean resp = enderecoService.delEndereco(id);
		if(resp) {
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}	
	}
}


