package br.edu.ifpr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Alternativas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String enunciado;
	
	private Boolean correto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_questao")
	private Questao questao;
	
	@ManyToMany(mappedBy="respostas")
	private List<RealizarProva> realizar;

	public Alternativas() {
	
	}

	public Alternativas(String enunciado, Boolean correto, Questao questao) {
		this.enunciado = enunciado;
		this.correto = correto;
		this.questao = questao;
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

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	
}
