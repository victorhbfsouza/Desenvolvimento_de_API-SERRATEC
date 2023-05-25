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

import com.grupo5.ecommerce.entities.Item_Pedido;
import com.grupo5.ecommerce.services.Item_PedidoService;

@RestController
@RequestMapping(value = "/item_pedidos")
public class Item_PedidoController {
	
	@Autowired
	Item_PedidoService item_pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Item_Pedido>> getAllItem_Pedidos() {
		return new ResponseEntity<>(item_pedidoService.getAllItem_Pedidos(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Item_Pedido> getItem_PedidoById(@PathVariable Integer id) {
		//return item_pedidoService.getItem_PedidoById(id);
		Item_Pedido item_pedidoResponse = item_pedidoService.getItem_PedidoById(id);
		if(null == item_pedidoResponse) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(item_pedidoResponse, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Item_Pedido> saveItem_Pedido(@RequestBody Item_Pedido item_pedido) {
		return new ResponseEntity<>(item_pedidoService.saveItem_Pedido(item_pedido), HttpStatus.CREATED);
	}
	
	@PutMapping (value = "/{id}")
	//@PutMapping(value = "/{id}")
	public ResponseEntity<Item_Pedido> updateItem_Pedido(@RequestBody Item_Pedido item_pedido, Integer id) {
		return new ResponseEntity<>(item_pedidoService.updateItem_Pedido(item_pedido, id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
		public ResponseEntity<Boolean> delItem_Pedido(@PathVariable Integer id) {
		//return item_pedidoService.delItem_Pedido(id);
		Boolean resp = item_pedidoService.delItem_Pedido(id);
		if(resp) {
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(resp, HttpStatus.NOT_MODIFIED);
		}	
	}
}
