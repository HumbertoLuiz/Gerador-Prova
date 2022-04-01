package br.edu.ifpr.app.sae.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpr.app.sae.model.Alternativa;
import br.edu.ifpr.app.sae.model.QuestaoObjetiva;
import br.edu.ifpr.app.sae.repository.QuestaoObjetivaRepository;
import br.edu.ifpr.app.sae.service.QuestaoObjetivaService;

@Service
public class QuestaoObjetivaImplService implements QuestaoObjetivaService {
	
	    @Autowired
	    private QuestaoObjetivaRepository questaoObjetivaRepository;     
	    
	
	    public void addRow(QuestaoObjetiva questaoObjetiva) {
	        questaoObjetiva.getAlternativaList().add(new Alternativa());
	       
	    }    	   
			
	   @Override
		public QuestaoObjetiva createQuestao() {
			 return new QuestaoObjetiva();
		}

		@Override
		public QuestaoObjetiva saveQuestao(QuestaoObjetiva questaoObjetiva) {
			 return questaoObjetivaRepository.save(questaoObjetiva);
		}

		@Override
		public List<QuestaoObjetiva> findAllQuestoes() {
			return questaoObjetivaRepository.findAll();
		}
		


		
	}



