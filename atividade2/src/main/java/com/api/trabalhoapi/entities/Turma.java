package com.api.trabalhoapi.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "turma")
public class Turma {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_turma")
	private Integer idTurma;
	
	@Column (name = "nomedisciplina")
	private String nomeDisciplina;
	
	@Column (name = "diasemana")
	private String diaSemana;
	
	//@Column (name = "idinstrutor")
	//private Integer idInstrutor;
	
	@ManyToOne
	@JoinColumn (name = "id_instrutor", referencedColumnName = "id_instrutor")
	private Instrutor instrutor;

	public Integer getId() {
		return idTurma;
	}

	public void setId(Integer id) {
		this.idTurma = id;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
}
