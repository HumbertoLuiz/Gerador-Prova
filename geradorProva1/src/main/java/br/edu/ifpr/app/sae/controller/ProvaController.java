package br.edu.ifpr.app.sae.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpr.app.sae.factory.FactoryProvaStrategy;
import br.edu.ifpr.app.sae.model.Prova;
import br.edu.ifpr.app.sae.model.Questao;
import br.edu.ifpr.app.sae.model.QuestaoObjetiva;
import br.edu.ifpr.app.sae.model.QuestaoSubjetiva;
import br.edu.ifpr.app.sae.repository.ProvaRepository;
import br.edu.ifpr.app.sae.repository.QuestaoObjetivaRepository;
import br.edu.ifpr.app.sae.repository.QuestaoRepository;
import br.edu.ifpr.app.sae.repository.QuestaoSubjetivaRepository;
import br.edu.ifpr.app.sae.strategy.Context;
import br.edu.ifpr.app.sae.strategy.ProvaStrategy;

@Controller
@RequestMapping("/gerarProvas")
public class ProvaController {

	@Autowired
	ProvaRepository dao;
	
	@Autowired
	QuestaoRepository daoq;
	
	@Autowired
	QuestaoObjetivaRepository daoO;
	
	@Autowired
	QuestaoSubjetivaRepository daoS;
	

	@GetMapping("/new")
	public String index(Model model) {
				
		Prova p = new Prova();
		model.addAttribute("prova", p);
		List<Questao> questoes = daoq.findAll();
		List<QuestaoObjetiva> objetivas = daoO.findAll();
		List<Questao> selecao = new ArrayList<>();
		Random random = new Random();
		for (int i = 1; i <= questoes.size(); i++) {
			Questao questao = questoes.get(random.nextInt(questoes.size()));
			selecao.add(questao);
		}
		model.addAttribute("selecao", selecao);
		model.addAttribute("objetivas", objetivas);
		
		Context context = new Context();

		ProvaStrategy strategy = FactoryProvaStrategy.createStrategy(p); 
		context.setStrategy(strategy);		
		context.executarSalvar();
		return "geradorProva/gerarProva.html";
	}
	
	@GetMapping("/listProvas")
	public String list(Model model) {
		model.addAttribute("provasList", dao.findAll());
		return "geradorProva/listProvas.html";
	}	
	
//	@GetMapping("/questoes")
//	public String listaDeQuestoes(Model model) {
//		List<Questao> questoes = daoq.findAll();
//		List<Questao> selecao = new ArrayList<>();
//		Random random = new Random();
//		for (int i = 1; i <= questoes.size(); i++) {
//			Questao questao = questoes.get(random.nextInt(questoes.size()));
//			selecao.add(questao);
//		}
//		model.addAttribute("selecao", selecao);
//	//	model.addAttribute("corretas", Correta.values());
//		return "gerarProva/listProvas.html";
//	}	

	@PostMapping("/save")
	public String save(@Valid Prova p, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "gerarProva/realizarProvaObjetiva.html";
		} dao.save(p);
			

		return "redirect:/gerarProvas/listProvas";
	}
	
}

	

