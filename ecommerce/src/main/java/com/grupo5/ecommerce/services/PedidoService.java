package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.ecommerce.entities.Pedido;
import com.grupo5.ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido> getAllPedidos() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return pedidos;
	}
	
	public Pedido getPedidoById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id).orElse(null);
		
		if(pedido==null)
			return null;
		
		return pedido;
	}
	
	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido updatePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	   public Boolean delPedido(Integer id) {
		  if(pedidoRepository.findById(id).orElse(null)!=null) {
			  pedidoRepository.deleteById(id);
			  if(pedidoRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	      }
}
