package br.edu.ifpr.app.sae.service;

import java.util.List;

import br.edu.ifpr.app.sae.model.QuestaoObjetiva;

public interface QuestaoObjetivaService {
	
	    QuestaoObjetiva createQuestao();
	    QuestaoObjetiva saveQuestao(QuestaoObjetiva questaoObjetiva);
	    void addRow(QuestaoObjetiva questaoObjetiva);
	    List<QuestaoObjetiva> findAllQuestoes();

}
