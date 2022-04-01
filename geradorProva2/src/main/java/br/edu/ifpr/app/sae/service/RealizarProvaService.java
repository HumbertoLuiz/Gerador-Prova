package br.edu.ifpr.app.sae.service;

import java.util.List;
import br.edu.ifpr.app.sae.model.RealizarProva;

public interface RealizarProvaService {
	
	    RealizarProva createRealizarProva();
	    RealizarProva saveRealizarProva(RealizarProva realizarProva);
	    void addRow(RealizarProva realizarProva);
	    List<RealizarProva> findAllRealizarProvas();

}
