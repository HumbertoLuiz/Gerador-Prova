package br.edu.ifpr.model;

import java.util.ArrayList;
import java.util.List;

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
	@Column(name = "id_prova")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@ManyToMany
    @JoinTable(name = "prova_objetiva", joinColumns = @JoinColumn(name = "prova_id", referencedColumnName = "id_prova"),
    	inverseJoinColumns = @JoinColumn(name = "questaoObjetiva_id", referencedColumnName = "id_questao"))             
    private List<QuestaoObjetiva> objetivas = new ArrayList<>();
	
	@ManyToMany
    @JoinTable(name = "prova_subjetiva", joinColumns = @JoinColumn(name = "prova_id", referencedColumnName = "id_prova"),
    	inverseJoinColumns = @JoinColumn(name = "questaoSubjetiva_id", referencedColumnName = "id_questao"))             
    private List<QuestaoSubjetiva> subjetivas = new ArrayList<>();

	public Prova() {
		// TODO Auto-generated constructor stub
	}

	public Prova(Tipo tipo, List<QuestaoObjetiva> objetivas, List<QuestaoSubjetiva> subjetivas) {
		this.tipo = tipo;
		this.objetivas = objetivas;
		this.subjetivas = subjetivas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
