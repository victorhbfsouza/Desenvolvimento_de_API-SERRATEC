package com.grupo5.atividade1.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instrutor")
public class instrutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "rg")
	private Integer rg;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "turma")
	private List<turma> turmas;
	//verificar
	
	@OneToOne (mappedBy = "telefone")
	private Integer telefone;
	//Verificar

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<turma> turmas) {
		this.turmas = turmas;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

}
