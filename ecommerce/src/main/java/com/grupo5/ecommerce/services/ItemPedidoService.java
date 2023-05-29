package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.ecommerce.entities.ItemPedido;
import com.grupo5.ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public List<ItemPedido> getAllItemPedidos() {
		List<ItemPedido> itemPedidos = itemPedidoRepository.findAll();
		return itemPedidos;
	}
	
	public ItemPedido getItemPedidoById(Integer id) {
		ItemPedido itemPedido = itemPedidoRepository.findById(id).orElse(null);
		
		if(itemPedido==null)
			return null;
		
		return itemPedido;
	}
	
	public ItemPedido saveItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	
	public ItemPedido updateItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	
	   public Boolean delItemPedido(Integer id) {
		  if(itemPedidoRepository.findById(id).orElse(null)!=null) {
			  itemPedidoRepository.deleteById(id);
			  if(itemPedidoRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	      }
}
