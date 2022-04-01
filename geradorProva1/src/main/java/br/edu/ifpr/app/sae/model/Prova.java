package br.edu.ifpr.app.sae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name = "prova")
public class Prova {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_prova")
	private Integer id;	
	
	@Transient
	private Boolean marcada;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prova_objetiva", joinColumns = @JoinColumn(name = "prova_id", referencedColumnName = "id_prova"),
    	inverseJoinColumns = @JoinColumn(name = "questaoObjetiva_id", referencedColumnName = "id_questao"))             
    private List<QuestaoObjetiva> objetivas ;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prova_subjetiva", joinColumns = @JoinColumn(name = "prova_id", referencedColumnName = "id_prova"),
    	inverseJoinColumns = @JoinColumn(name = "questaoSubjetiva_id", referencedColumnName = "id_questao"))             
    private List<QuestaoSubjetiva> subjetivas ;

	public Prova() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getMarcada() {
		return marcada;
	}

	public void setMarcada(Boolean marcada) {
		this.marcada = marcada;
	}

	public List<QuestaoObjetiva> getObjetivas() {
		return objetivas;
	}

	public void setObjetivas(List<QuestaoObjetiva> objetivas) {
		this.objetivas = objetivas;
	}

	public List<QuestaoSubjetiva> getSubjetivas() {
		return subjetivas;
	}

	public void setSubjetivas(List<QuestaoSubjetiva> subjetivas) {
		this.subjetivas = subjetivas;
	}

	

}
