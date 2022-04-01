package br.edu.ifpr.app.sae.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpr.app.sae.model.QuestaoSubjetiva;
import br.edu.ifpr.app.sae.model.RealizarProva;
import br.edu.ifpr.app.sae.repository.RealizarProvaRepository;
import br.edu.ifpr.app.sae.service.RealizarProvaService;

@Service
public class RealizarProvaImplService implements RealizarProvaService {
	
	    @Autowired
	    private RealizarProvaRepository realizarProvaRepository;     
	    
	
	    public void addRow(RealizarProva realizarProva) {
	        realizarProva.getQuestoes().add(new QuestaoSubjetiva());
	       
	    }    	   
			
	   @Override
		public RealizarProva createRealizarProva() {
			 return new RealizarProva();
		}

		@Override
		public RealizarProva saveRealizarProva(RealizarProva realizarProva) {
			 return realizarProvaRepository.save(realizarProva);
		}

		@Override
		public List<RealizarProva> findAllRealizarProvas() {
			return realizarProvaRepository.findAll();
		}
		


		
	}



