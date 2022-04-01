package br.edu.ifpr.app.sae.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
	private Boolean correto;
	
	@Column
	private String enunciado;
		
	@Transient
    private Integer sequenceNumber;
	  
	@Transient
	private List<Alternativa> alternativas;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Questao questoes;

	public Alternativa() {}
	
	public Alternativa(String enunciado, Boolean correto, Questao questoes) {
		this.enunciado = enunciado;
		this.correto = correto;
		this.questoes = questoes;
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

	public Boolean getCorreto() {
		return correto;
	}

	public void setCorreto(Boolean correto) {
		this.correto = correto;
	}

	public Questao getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questao questoes) {
		this.questoes = questoes;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

}
