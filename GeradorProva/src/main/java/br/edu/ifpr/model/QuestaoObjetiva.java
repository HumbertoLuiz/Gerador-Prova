package br.edu.ifpr.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class QuestaoObjetiva extends Questao{	
	
	
 	@ManyToMany
     @JoinTable(name = "objetiva_alternativas", joinColumns = @JoinColumn(name = "qustaoObjetiva_id", referencedColumnName = "id_questao"),
    	inverseJoinColumns = @JoinColumn(name = "altenativas_id", referencedColumnName = "id_alternativas"))        
	 private List<Alternativas> alternativas = new ArrayList<>();

	public QuestaoObjetiva() {
		// TODO Auto-generated constructor stub
	}

	public QuestaoObjetiva(String enunciado, String assunto, Float nota, Nivel nivel) {
		super(enunciado, assunto, nota, nivel);		
	}

	public QuestaoObjetiva(String enunciado, String assunto, Float nota, Nivel nivel, List<Alternativas> alternativas) {
		super(enunciado, assunto, nota, nivel);
		this.alternativas = alternativas;
	}

	public List<Alternativas> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativas> alternativas) {
		this.alternativas = alternativas;
	}

	

}
