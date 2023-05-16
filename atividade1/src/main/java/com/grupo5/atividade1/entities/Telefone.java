package com.grupo5.atividade1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone")
	private Integer id_telefone;
	
	@Column(name = "numero")
	private Integer numero;
	
	@OneToOne
	@JoinColumn (name = "id_instrutor", referencedColumnName = "id_instrutor")
	private Instrutor id_instrutor;

	public Integer getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(Integer id_telefone) {
		this.id_telefone = id_telefone;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Instrutor getId_instrutor() {
		return id_instrutor;
	}

	public void setId_instrutor(Instrutor id_instrutor) {
		this.id_instrutor = id_instrutor;
	}
	
}
