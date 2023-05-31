package com.grupo5.ecommerce.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class RelatorioPedidoDTO {
	
	private Integer id_pedido; 
	private Instant data_pedido;
	private Double valor_total;
	private List<RelatorioPedidoItemDTO> listaItemPedidoDTO;
	
	public RelatorioPedidoDTO() {
		super();
	}

	public RelatorioPedidoDTO(Integer id_pedido, Instant data_pedido, Double valor_total,
			List<RelatorioPedidoItemDTO> listaItemPedidoDTO) {
		super();
		this.id_pedido = id_pedido;
		this.data_pedido = data_pedido;
		this.valor_total = valor_total;
		this.listaItemPedidoDTO = listaItemPedidoDTO;
	}

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Instant getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Instant data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public List<RelatorioPedidoItemDTO> getListaItemPedidoDTO() {
		return listaItemPedidoDTO;
	}

	public void setListaItemPedidoDTO(List<RelatorioPedidoItemDTO> listaItemPedidoDTO) {
		this.listaItemPedidoDTO = listaItemPedidoDTO;
	}
}
