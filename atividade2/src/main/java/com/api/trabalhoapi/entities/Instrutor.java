package com.api.trabalhoapi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "instrutor")
public class Instrutor {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_instrutor")
	private Integer idInstrutor;
	
	@Column (name = "rg")
	private Integer rg;
	
	@Column (name = "nome")
	private String nome;

	@JsonIgnore
	@OneToMany (mappedBy = "instrutor")
	private List<Turma> turma;
	
	@OneToOne(mappedBy = "instrutor")
	private Telefone telefone;
	
	public Integer getId() {
		return idInstrutor;
	}

	public void setId(Integer id) {
		this.idInstrutor = id;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
}
