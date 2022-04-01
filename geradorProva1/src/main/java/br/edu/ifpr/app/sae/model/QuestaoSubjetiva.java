package br.edu.ifpr.app.sae.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import br.edu.ifpr.app.sae.strategy.ProvaStrategy;

@Entity(name = "questaoSubjetiva")
public class QuestaoSubjetiva extends Questao implements ProvaStrategy {
		
	
	private String Resposta;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "prova_subjetiva", joinColumns = @JoinColumn(name = "questaoSubjetiva_id", referencedColumnName = "id_questao"),
    	inverseJoinColumns = @JoinColumn(name = "prova_id", referencedColumnName = "id_prova"))             
    private Prova prova;
	

	public QuestaoSubjetiva(String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo, String resposta) {
		super(enunciado, assunto, nota, nivel, tipo);
		Resposta = resposta;
	}

	public QuestaoSubjetiva() {}

	@Override	
	public String redirect() {	

		return "redirect:/gerarProvas/new";
	}

	public QuestaoSubjetiva(Integer id, String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo,
			List<Alternativa> alternativaList) {
		super(id, enunciado, assunto, nota, nivel, tipo, alternativaList);
	}


	public QuestaoSubjetiva(String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo) {
		super(enunciado, assunto, nota, nivel, tipo);
	}


	public QuestaoSubjetiva(Integer id, String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo,
			List<Alternativa> alternativaList, String resposta, Prova prova) {
		super(id, enunciado, assunto, nota, nivel, tipo, alternativaList);
		Resposta = resposta;
		this.prova = prova;
	}


	public String getResposta() {
		return Resposta;
	}


	public void setResposta(String resposta) {
		Resposta = resposta;
	}


	public Prova getProva() {
		return prova;
	}


	public void setProva(Prova prova) {
		this.prova = prova;
	}

}
