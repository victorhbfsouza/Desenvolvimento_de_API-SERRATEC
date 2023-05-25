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

import com.grupo5.ecommerce.entities.Pedido;
import com.grupo5.ecommerce.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> getAllPedidos() {
		return new ResponseEntity<>(pedidoService.getAllPedidos(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
		//return pedidoService.getPedidoById(id);
		Pedido pedidoResponse = pedidoService.getPedidoById(id);
		if(null == pedidoResponse) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(pedidoResponse, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido) {
		return new ResponseEntity<>(pedidoService.savePedido(pedido), HttpStatus.CREATED);
	}
	
	@PutMapping (value = "/{id}")
	//@PutMapping(value = "/{id}")
	public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido, Integer id) {
		return new ResponseEntity<>(pedidoService.updatePedido(pedido, id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
		public ResponseEntity<Boolean> delPedido(@PathVariable Integer id) {
		//return pedidoService.delPedido(id);
		Boolean resp = pedidoService.delPedido(id);
		if(resp) {
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}	
	}
}
