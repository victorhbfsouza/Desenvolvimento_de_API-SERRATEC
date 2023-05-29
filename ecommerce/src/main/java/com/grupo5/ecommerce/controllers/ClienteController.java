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

import com.grupo5.ecommerce.entities.Cliente;
import com.grupo5.ecommerce.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return new ResponseEntity<>(clienteService.getAllClientes(),
                HttpStatus.OK);
     }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Cliente clienteResponse = clienteService.getClienteById(id);
        if(null == clienteResponse)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.saveCliente(cliente),HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, Integer id) {
    	if(clienteService.getClienteById(cliente.getIdCliente()) != null) {
            return new ResponseEntity<> (clienteService.updateCliente(cliente),
                    HttpStatus.OK);
        }
        else {
            return new ResponseEntity<> (cliente,
                    HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delCliente(@PathVariable Integer id) {
        Boolean resp = clienteService.delCliente(id);
        if(resp)
        	return new ResponseEntity<>(resp,HttpStatus.OK);
        else
        	return new ResponseEntity<>(resp,HttpStatus.NOT_MODIFIED);
    }
}
