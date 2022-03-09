package br.edu.ifpr.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Alternativas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_alternativas")
	private Integer id;
	
	private String enunciado;
	
	private Boolean correto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_questao")
	private Questao questaoObjetiva;

	public Alternativas() {
	
	}

	public Alternativas(String enunciado, Boolean correto, Questao questaoObjetiva) {
		this.enunciado = enunciado;
		this.correto = correto;
		this.questaoObjetiva = questaoObjetiva;
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

	public Boolean getCorreto() {
		return correto;
	}

	public void setCorreto(Boolean correto) {
		this.correto = correto;
	}

	public Questao getQuestaoObjetiva() {
		return questaoObjetiva;
	}

	public void setQuestaoObjetiva(Questao questaoObjetiva) {
		this.questaoObjetiva = questaoObjetiva;
	}
	
	
	

}
