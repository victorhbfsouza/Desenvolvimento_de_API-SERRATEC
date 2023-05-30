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

import com.grupo5.ecommerce.entities.ItemPedido;
import com.grupo5.ecommerce.services.ItemPedidoService;

@RestController
@RequestMapping("/itempedidos")
public class ItemPedidoController {
	
	@Autowired
	ItemPedidoService itemPedidoService;
	
	@GetMapping
    public ResponseEntity<List<ItemPedido>> getAllItemPedidos() {
        return new ResponseEntity<>(itemPedidoService.getAllItemPedidos(),
                HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> getItemPedidoById(@PathVariable Integer id) {
        ItemPedido itemPedidoResponse = itemPedidoService.getItemPedidoById(id);
        if(null == itemPedidoResponse)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(itemPedidoResponse, HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<ItemPedido> saveItemPedido(@RequestBody ItemPedido itemPedido) {
        return new ResponseEntity<>(itemPedidoService.saveItemPedido(itemPedido),HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> updateItemPedido(@RequestBody ItemPedido itemPedido) {
    	if(itemPedidoService.getItemPedidoById(itemPedido.getIdItemPedido()) != null) {
            return new ResponseEntity<> (itemPedidoService.updateItemPedido(itemPedido),
                    HttpStatus.OK);
        }
        else {
            return new ResponseEntity<> (itemPedido,
                    HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delItemPedido(@PathVariable Integer id) {
        Boolean resp = itemPedidoService.delItemPedido(id);
        if(resp)
        	return new ResponseEntity<>(resp,HttpStatus.OK);
        else
        	return new ResponseEntity<>(resp,HttpStatus.NOT_MODIFIED);
    }
}
