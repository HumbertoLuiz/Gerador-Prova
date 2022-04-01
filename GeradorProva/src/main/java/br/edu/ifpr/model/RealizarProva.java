package br.edu.ifpr.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class RealizarProva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prova")
	private Prova prova;	
	 
	
	@ManyToMany
    @JoinTable(name = "realizarprova_alternativas", joinColumns = @JoinColumn(name = "realizarprova_id"),
   	inverseJoinColumns = @JoinColumn(name = "altenativas_id"))        
	 private List<Alternativas> respostas = new ArrayList<>();

	public RealizarProva() {

	}


	public RealizarProva(Prova prova, List<Alternativas> respostas) {
		this.prova = prova;
		this.respostas = respostas;

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Prova getProva() {
		return prova;
	}


	public void setProva(Prova prova) {
		this.prova = prova;
	}


	public List<Alternativas> getRespostas() {
		return respostas;
	}


	public void setRespostasObjetivas(List<Alternativas> respostas) {
		this.respostas = respostas;
	}


	

}
