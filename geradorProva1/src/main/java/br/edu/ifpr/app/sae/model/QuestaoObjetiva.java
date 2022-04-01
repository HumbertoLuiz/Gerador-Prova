package br.edu.ifpr.app.sae.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpr.app.sae.repository.QuestaoObjetivaRepository;
import br.edu.ifpr.app.sae.repository.QuestaoRepository;
import br.edu.ifpr.app.sae.strategy.ProvaStrategy;


@Entity(name = "questaoOjetiva")
public class QuestaoObjetiva extends Questao implements ProvaStrategy {	
	

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alternativa> alternativaList  = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "prova_objetiva", joinColumns = @JoinColumn(name = "questaoObjetiva_id", referencedColumnName = "id_questao"),
    	inverseJoinColumns = @JoinColumn(name = "prova_id", referencedColumnName = "id_prova"))             
    private Prova prova;
	
	public QuestaoObjetiva() {}
	
	
	@Override	
	public String redirect() {	

		return "redirect:/gerarProvas/new";
	}
	
	public QuestaoObjetiva(String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo) {
		super(enunciado, assunto, nota, nivel, tipo);
	}

	public QuestaoObjetiva(String enunciado, String assunto, Float nota, Nivel nivel, Tipo tipo,
			List<Alternativa> alternativaList) {
		super(enunciado, assunto, nota, nivel, tipo);
		this.alternativaList = alternativaList;
	}


	public List<Alternativa> getAlternativaList() {
		return alternativaList;
	}

	public void setAlternativaList(List<Alternativa> alternativaList) {
		this.alternativaList = alternativaList;
	} 		

}
