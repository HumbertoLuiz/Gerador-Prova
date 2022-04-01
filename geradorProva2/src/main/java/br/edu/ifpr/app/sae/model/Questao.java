package br.edu.ifpr.app.sae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public abstract class Questao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Lob
	@Column
	private String enunciado;
	
	@Column
	private String assunto;
	
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@ManyToMany
	@JoinTable(name = "questao_realizarprova", joinColumns = { @JoinColumn(name = "questao_id") }, inverseJoinColumns = {
			@JoinColumn(name = "realizarprova_id") })       
	private List<RealizarProva> realizarProvas = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alternativa> alternativaList  = new ArrayList<>();	

	public Questao() {}

	public Questao(String enunciado, String assunto, Nivel nivel, Tipo tipo, 
			List<RealizarProva> realizarProvas, List<Alternativa> alternativaList) {
		this.enunciado = enunciado;
		this.assunto = assunto;
		this.nivel = nivel;
		this.tipo = tipo;
		this.realizarProvas = realizarProvas;
		this.alternativaList = alternativaList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}	

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<RealizarProva> getRealizarProvas() {
		return realizarProvas;
	}

	public void setRealizarProvas(List<RealizarProva> realizarProvas) {
		this.realizarProvas = realizarProvas;
	}

	public List<Alternativa> getAlternativaList() {
		return alternativaList;
	}

	public void setAlternativaList(List<Alternativa> alternativaList) {
		this.alternativaList = alternativaList;
	}

}
