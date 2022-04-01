package br.edu.ifpr.model;

import javax.persistence.Entity;

@Entity
public class QuestaoObjetiva extends Questao{	
	
	
	public QuestaoObjetiva() {
		// TODO Auto-generated constructor stub
	}

	public QuestaoObjetiva(String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo) {
		super(enunciado, assunto, nota, nivel, tipo);		
	}	

}
