package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupo5.ecommerce.entities.Pedido;
import com.grupo5.ecommerce.repositories.PedidoRepository;

public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}
	
	public Pedido getPedidoById(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
	
	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	
	public Pedido updatePedido(Pedido pedido, Integer id) {
		return pedidoRepository.save(pedido);
	}
	
	public void deletePedido(Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	public Boolean delPedido(Integer id) {
		pedidoRepository.deleteById(id);
		Pedido pedidoDeletado = pedidoRepository.findById(id).orElse(null);
		if (null == pedidoDeletado) {
			return true;
		}else {
			return false;
		}
	}
}
