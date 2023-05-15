package com.grupo5.atividade1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome_disciplina")
	private String nome_disciplina;
	
	@Column(name = "dia_semana")
	private Integer dia_semana;
	
	@ManyToOne
	@JoinColumn(name = "instrutor", referencedColumnName = "id")
	private Integer id_instrutor;
	//VERIFICAR

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	public Integer getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(Integer dia_semana) {
		this.dia_semana = dia_semana;
	}

	public Integer getId_instrutor() {
		return id_instrutor;
	}

	public void setId_instrutor(Integer id_instrutor) {
		this.id_instrutor = id_instrutor;
	}

}
