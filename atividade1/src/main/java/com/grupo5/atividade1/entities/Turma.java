package com.grupo5.atividade1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Integer id_turma;
	
	@Column(name = "nome_disciplina")
	private String nome_disciplina;
	
	@Column(name = "dia_semana")
	private Integer dia_semana;
	
	@JsonIgnore //aula 16/05
	@ManyToOne
	@JoinColumn (name = "id_instrutor", referencedColumnName = "id_instrutor")
	private Instrutor id_instrutor;

	public Integer getId_turma() {
		return id_turma;
	}

	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
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

	public Instrutor getId_instrutor() {
		return id_instrutor;
	}

	public void setId_instrutor(Instrutor id_instrutor) {
		this.id_instrutor = id_instrutor;
	}
	
}
