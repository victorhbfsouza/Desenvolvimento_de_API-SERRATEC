package com.api.trabalhoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "telefone")
public class Telefone {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_telefone")
	private Integer idTelefone;
	
	@Column (name = "numero")
	private Integer numero;
	
	//@Column (name = "idinstrutor")
	//private Integer idInstrutor;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_instrutor", referencedColumnName = "id_instrutor")
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
