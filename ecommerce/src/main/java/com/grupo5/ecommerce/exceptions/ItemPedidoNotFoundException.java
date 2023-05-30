package com.grupo5.ecommerce.exceptions;

public class ItemPedidoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ItemPedidoNotFoundException(Integer id) {
		super("Não foi encontrado Pedido com o id = " + id);
	}
}