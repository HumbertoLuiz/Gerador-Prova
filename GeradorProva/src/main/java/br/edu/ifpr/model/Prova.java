package br.edu.ifpr.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
public class Prova {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
	@ManyToMany
	@JoinTable(name = "prova_objetiva", joinColumns = { @JoinColumn(name = "prova_id") }, inverseJoinColumns = {
			@JoinColumn(name = "questao_id") })
	private List<Questao> objetivas;	


	public Prova() {
		// TODO Auto-generated constructor stub
	}

	public Prova(Nivel nivel, List<Questao> objetivas) {
		this.nivel = nivel;
		this.objetivas = objetivas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<Questao> getObjetivas() {
		return objetivas;
	}

	public void setObjetivas(List<Questao> objetivas) {
		this.objetivas = objetivas;
	}


	

}
