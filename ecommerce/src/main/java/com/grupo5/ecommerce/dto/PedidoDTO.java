package com.grupo5.ecommerce.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.grupo5.ecommerce.entities.Cliente;


public class PedidoDTO {
	
	private Integer idPedido;
	
	private Instant dataPedido;
	
	private Instant dataEntrega;
	
	private Instant dataEnvio;
	
	private String status;
	
	private BigDecimal valorTotal;
	
	private Cliente cliente;
	
	private Set<ItemPedidoDTO> produtos = new HashSet<>();

	public PedidoDTO(Integer idPedido, Instant dataPedido, Instant dataEntrega, Instant dataEnvio, String status,
			BigDecimal valorTotal, Cliente cliente, Set<ItemPedidoDTO> produtos) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.produtos = produtos;
	}

	public PedidoDTO() {
		super();
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Instant getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Instant dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Instant getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Instant dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ItemPedidoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ItemPedidoDTO> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	 public String toString() {
		
		String result = "Pedido número: "+ idPedido + "\n\nData do Pedido: " + dataPedido + "\nData de Entrega: " + dataEntrega + "\nData de envio: " + dataEnvio + "\n\nStatus do pedido: " + status + "\n\nValor total do pedido: R$" + valorTotal;
		
		if(cliente != null)
			result = result + "\n\nCliente: " + cliente;
		
		result = result + "\nProdutos do pedido: " + produtos;
				return result;
	}	
}
