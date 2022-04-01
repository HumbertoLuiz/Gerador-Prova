package br.edu.ifpr.app.sae.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class RealizarProva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;	
	
	@Lob
	@Column
	private String resposta;
	
	private Boolean marcada;
	

	@ManyToMany(mappedBy="realizarProvas")
	private List<Questao> questoes;
	
	public RealizarProva() {}

	public RealizarProva(String resposta, Boolean marcada, List<Questao> questoes) {
		this.resposta = resposta;
		this.marcada = marcada;
		this.questoes = questoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Boolean getMarcada() {
		return marcada;
	}

	public void setMarcada(Boolean marcada) {
		this.marcada = marcada;
	}

}
