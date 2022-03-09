package br.edu.ifpr.model;

import javax.persistence.Entity;

@Entity
public class QuestaoSubjetiva extends Questao {
	
	private String Resposta;

	public QuestaoSubjetiva() {
		// TODO Auto-generated constructor stub
	}

	public QuestaoSubjetiva(String enunciado, String assunto, Float nota, Nivel nivel) {
		super(enunciado, assunto, nota, nivel);
		// TODO Auto-generated constructor stub
	}

	public QuestaoSubjetiva(String enunciado, String assunto, Float nota, Nivel nivel, String resposta) {
		super(enunciado, assunto, nota, nivel);
		Resposta = resposta;
	}
//	

	public String getResposta() {
		return Resposta;
	}

	public void setResposta(String resposta) {
		Resposta = resposta;
	}
	
	


}
