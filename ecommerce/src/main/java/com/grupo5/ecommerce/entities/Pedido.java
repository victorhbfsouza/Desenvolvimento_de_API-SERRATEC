package com.grupo5.ecommerce.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@JsonIdentityInfo(
		scope = Pedido.class,
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idPedido"
		)
@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer idPedido;
	
	@Column(name = "data_pedido")
	private Instant dataPedido;
	
	@Column(name = "data_entrega")
	private Instant dataEntrega;
	
	@Column(name = "data_envio")
	private Instant dataEnvio;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", 
					referencedColumnName = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido")
	private Set<ItemPedido> produtos = new HashSet<>();
	
	public Integer getidPedido() {
		return idPedido;
	}
	public void setidPedido(Integer idPedido) {
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
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", dataPedido=" + dataPedido + ", dataEntrega="
				+ dataEntrega + ", dataEnvio=" + dataEnvio + ", status=" + status + ", valorTotal=" + valorTotal
				+ ", cliente=" + cliente + "]";
	}
}
