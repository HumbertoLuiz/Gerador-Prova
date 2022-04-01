package br.edu.ifpr.app.sae.factory;

import br.edu.ifpr.app.sae.model.Prova;
import br.edu.ifpr.app.sae.model.QuestaoObjetiva;
import br.edu.ifpr.app.sae.model.QuestaoSubjetiva;
import br.edu.ifpr.app.sae.strategy.ProvaStrategy;

public class FactoryProvaStrategy {

	public static ProvaStrategy createStrategy (Prova p) {
	
	ProvaStrategy strategy = null;
	
	if (!p.equals(null)) {
		strategy = new QuestaoObjetiva();
		
	} else if (!p.equals(null)) {
		strategy = new QuestaoSubjetiva();
		
	}
	
	return strategy;
	
	}
}
