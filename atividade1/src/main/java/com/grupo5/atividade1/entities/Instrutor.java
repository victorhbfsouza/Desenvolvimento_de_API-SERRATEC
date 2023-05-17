package com.grupo5.atividade1.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instrutor")
public class Instrutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_instrutor")
	private Integer id_instrutor;
	
	@Column(name = "rg")
	private Integer rg;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "id_instrutor")
	private List <Turma> turmas;
	
	@OneToOne
	@JoinColumn (name = "id_instrutor")
	private Telefone telefone;

	public Integer getId_instrutor() {
		return id_instrutor;
	}

	public void setId_instrutor(Integer id_instrutor) {
		this.id_instrutor = id_instrutor;
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

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
}
