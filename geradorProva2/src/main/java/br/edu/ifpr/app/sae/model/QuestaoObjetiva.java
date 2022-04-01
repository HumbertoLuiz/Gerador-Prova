package br.edu.ifpr.app.sae.model;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class QuestaoObjetiva extends Questao{	

	public QuestaoObjetiva() {}
	
	public QuestaoObjetiva(String enunciado, String assunto, Nivel nivel, Tipo tipo,
			List<Alternativa> alternativaList, List<RealizarProva> realizarProvas) {
			super(enunciado, assunto, nivel, tipo, realizarProvas, alternativaList);
	}

}
