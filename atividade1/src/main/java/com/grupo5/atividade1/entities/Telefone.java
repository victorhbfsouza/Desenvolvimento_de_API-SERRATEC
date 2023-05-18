package com.grupo5.atividade1.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idTelefone"
		)
@Entity
@Table (name = "telefone")
public class Telefone {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idtelefone")
	private Integer idTelefone;
	
	@Column (name = "numero")
	private Integer numero;
	
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Instrutor instrutor;
	
	public Integer getId() {
		return idTelefone;
	}

	public void setId(Integer id) {
		this.idTelefone = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
}
