package br.edu.ifpr.app.sae.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpr.app.sae.model.QuestaoObjetiva;
import br.edu.ifpr.app.sae.model.QuestaoSubjetiva;
import br.edu.ifpr.app.sae.model.RealizarProva;
import br.edu.ifpr.app.sae.repository.QuestaoObjetivaRepository;
import br.edu.ifpr.app.sae.repository.QuestaoSubjetivaRepository;
import br.edu.ifpr.app.sae.repository.RealizarProvaRepository;
import br.edu.ifpr.app.sae.service.RealizarProvaService;

@Controller
@RequestMapping("/realizarProva")
public class RealizarProvaController {
	
	@Autowired
	RealizarProvaRepository dao;
	
	@Autowired
	QuestaoObjetivaRepository daoO;
	
	@Autowired
	QuestaoSubjetivaRepository daoS;
	
	
	@Autowired
	RealizarProvaService realizarProvaService;
	
	@RequestMapping("/new")
	public String index(Model model) {
		RealizarProva realizarProva = new RealizarProva();
		model.addAttribute("realizarProva", realizarProva);
		List<QuestaoObjetiva> objetivas = daoO.findAll();
		List<QuestaoSubjetiva> subjetivas = daoS.findAll();
		model.addAttribute("selecaoObjetivas", objetivas);
		model.addAttribute("selecaoSubjetivas", subjetivas);
		return "gerarProva/realizarProva.html";
	}
	
	@GetMapping("/respostasList")
	public String list(Model model) {
		model.addAttribute("respostasList", dao.findAll());
		List<QuestaoObjetiva> obj = daoO.findAll();
		List<QuestaoSubjetiva> subj = daoS.findAll();
		model.addAttribute("obj", obj);
		model.addAttribute("subj", subj);
		return "gerarProva/respostasList.html";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.removerRealizarProva(id);
		return "redirect:/realizarProva/respostas";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		RealizarProva realizarProva = dao.findById(id).get();
		model.addAttribute("realizarProva", realizarProva);
		return "gerarProva/realizarProva.html";
	}

	@PostMapping("/save")
	public String save(@Valid RealizarProva realizarProva, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "gerarProva/realizarProva.html";
		}dao.save(realizarProva);
		return "redirect:/realizarProva/respostasList";
	}
	
	@PostMapping("/addRow")
	public String addRow(RealizarProva realizarProva) {
		realizarProvaService.addRow(realizarProva);
		return "gerarProva/realizarProva :: resposta"; 
	}
}
