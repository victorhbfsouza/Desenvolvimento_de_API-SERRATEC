package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupo5.ecommerce.entities.Cliente;
import com.grupo5.ecommerce.repositories.ClienteRepository;

public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente getClienteById(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
	public Cliente updateCliente(Cliente cliente, Integer id) {
		return clienteRepository.save(cliente);
	}
	
	public void deleteCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
	
	public Boolean delCliente(Integer id) {
		clienteRepository.deleteById(id);
		Cliente clienteDeletado = clienteRepository.findById(id).orElse(null);
		if (null == clienteDeletado) {
			return true;
		}else {
			return false;
		}
	}
}
