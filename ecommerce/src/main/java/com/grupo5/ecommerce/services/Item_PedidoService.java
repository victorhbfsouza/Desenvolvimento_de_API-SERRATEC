package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupo5.ecommerce.entities.Item_Pedido;
import com.grupo5.ecommerce.repositories.Item_PedidoRepository;

public class Item_PedidoService {

	@Autowired
	Item_PedidoRepository item_pedidoRepository;
	
	public List<Item_Pedido> getAllItem_Pedidos() {
		return item_pedidoRepository.findAll();
	}
	
	public Item_Pedido getItem_PedidoById(Integer id) {
		return item_pedidoRepository.findById(id).orElse(null);
	}
	
	public Item_Pedido saveItem_Pedido(Item_Pedido item_pedido) {
		return item_pedidoRepository.save(item_pedido);
	}
	
	
	public Item_Pedido updateItem_Pedido(Item_Pedido item_pedido, Integer id) {
		return item_pedidoRepository.save(item_pedido);
	}
	
	public void deleteItem_Pedido(Integer id) {
		item_pedidoRepository.deleteById(id);
	}
	
	public Boolean delItem_Pedido(Integer id) {
		item_pedidoRepository.deleteById(id);
		Item_Pedido item_pedidoDeletado = item_pedidoRepository.findById(id).orElse(null);
		if (null == item_pedidoDeletado) {
			return true;
		}else {
			return false;
		}
	}
}

