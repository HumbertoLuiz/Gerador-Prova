package br.edu.ifpr.app.sae.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifpr.app.sae.model.Questao;
import br.edu.ifpr.app.sae.model.QuestaoObjetiva;
import br.edu.ifpr.app.sae.repository.QuestaoRepository;

public class QuestaoController {

	@Autowired
	QuestaoRepository dao;


	@GetMapping("/new")
	public String newForm(Model model) {
		Questao questao = new Questao();
		model.addAttribute("questao", questao);
		return "cadastrarQuestoes/cadastrarQuestoes.html";
	}
	
	@GetMapping("/listQuestoes")
	public String list(Model model) {
		model.addAttribute("questoesList", dao.findAll());
		return "cadastrarQuestoes/listQuestoes.html";
	}

/*	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.removerQuestao(id);
		return "redirect:/questoes/listQuestoes";
	}*/
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Questao questao = dao.findById(id).get();
		model.addAttribute("questao", questao);
		return "cadastrarQuestoes/cadastrarQuestoes.html";
	}

	@PostMapping("/save")
	public String save(@Valid QuestaoObjetiva questaoObjetiva, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "cadastrarQuestoes/cadastrarQuestoes.html";
		}dao.save(questaoObjetiva);
		return "redirect:/questoes/listQuestoes";
	}

}