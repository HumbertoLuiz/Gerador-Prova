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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Questao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_questao")
	private Integer id;
	
	@Lob
	private String enunciado;
	
	private String assunto;
	
	private Float nota;
	
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alternativa> alternativaList  = new ArrayList<>();
	
	public Questao() {
		// TODO Auto-generated constructor stub
	}

	
	public Questao(String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo) {
		this.enunciado = enunciado;
		this.assunto = assunto;
		this.nota = nota;
		this.nivel = nivel;
		this.tipo = tipo;
	}
	
	public Questao(Integer id, String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo, List<Alternativa> alternativaList) {
		this.id = id;
		this.enunciado = enunciado;
		this.assunto = assunto;
		this.nota = nota;
		this.nivel = nivel;
		this.tipo = tipo;
		this.alternativaList = alternativaList;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
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

	public List<Alternativa> getAlternativaList() {
		return alternativaList;
	}


	public void setAlternativaList(List<Alternativa> alternativaList) {
		this.alternativaList = alternativaList;
	}
		
}
