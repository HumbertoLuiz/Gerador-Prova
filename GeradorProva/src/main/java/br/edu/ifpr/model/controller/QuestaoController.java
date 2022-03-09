package br.edu.ifpr.model.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpr.model.Questao;
import br.edu.ifpr.repository.QuestaoRepository;

@Controller
@RequestMapping("/questoes")
public class QuestaoController {

	@Autowired
	QuestaoRepository dao;


	@GetMapping("/cadastrarQuestaoObjetiva")
	public String newForm(Model model) {
		Questao q = new Questao();
		model.addAttribute("questao", q);
		return "cadastrarQuestoes/cadastrarQuestaoObjetiva.html";
	}

	@GetMapping("/listQuestoes")
	public String list(Model model) {
		model.addAttribute("questoesList", dao.findAll());
		return "cadastrarQuestoes/listQuestoes.html";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		dao.removerQuestao(id);
		return "redirect:/cadastrarQuestoes/listQuestoes";
	}

	public String edit(@PathVariable Integer id, Model model) {

		Optional<Questao> questao = dao.findById(id);
		
		if (!questao.isPresent()) {
			throw new IllegalArgumentException("Inválido.");
		}
		model.addAttribute("questao", questao.get());

		return "cadastrarQuestoes/listQuestoes.html";

	}

	@PostMapping("/save")
	public String save(@Valid Questao questao, BindingResult result, Model model) {
		if (result.hasErrors())
			return "cadastrarQuestoes/cadastrarQuestaoObjetiva.html";
		dao.save(questao);
		return "redirect:/cadastrarQuestoes/listQuestoes";
	}
}

	

