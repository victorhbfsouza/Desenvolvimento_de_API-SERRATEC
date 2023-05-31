package com.grupo5.ecommerce.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.ecommerce.dto.PedidoDTO;
import com.grupo5.ecommerce.entities.Pedido;
import com.grupo5.ecommerce.exceptions.PedidoNotFoundException;
import com.grupo5.ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ModelMapper	modelMapper;
	
	public List<Pedido> getAllPedidos() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return pedidos;
	}
	
	public Pedido getPedidoById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id).orElseThrow(()
				-> new PedidoNotFoundException(id));
		
		if(pedido==null)
			return null;
		
		return pedido;
	}
	
	public Pedido savePedido(Pedido pedido) {

	
		pedido.AddTime();
		
		Pedido pedidoSalvo= pedidoRepository.save(pedido);
		
		PedidoDTO pedidoDtoResponse = modelMapper.map(pedidoSalvo, PedidoDTO.class);
		emailService.enviarEmail("victor.h.souza8@aluno.senai.br", "Pedido realizado com sucesso!", pedidoDtoResponse.toString());
		
		return pedidoSalvo;
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
