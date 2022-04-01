package br.edu.ifpr.app.sae.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpr.app.sae.model.QuestaoSubjetiva;
import br.edu.ifpr.app.sae.repository.QuestaoSubjetivaRepository;


@Controller
@RequestMapping("/questaoSubjetiva")
public class QuestaoSubjetivaController {

	@Autowired
	QuestaoSubjetivaRepository dao;


	@GetMapping("/new")
	public String newForm(Model model) {
		QuestaoSubjetiva subjetivas = new QuestaoSubjetiva();
		model.addAttribute("questaoSubjetiva", subjetivas);
		return "subjetiva/subjetivas.html";
	}
	
	@GetMapping("/listSubjetivas")
	public String list(Model model) {
		model.addAttribute("subjetivasList", dao.findAll());
		return "subjetiva/listSubjetivas.html";
	}

/*	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.removerSubjetiva(id);
		return "redirect:/subjetivas/listSubjetivas";
	}*/
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		QuestaoSubjetiva subjetivas = dao.findById(id).get();
		model.addAttribute("subjetivas", subjetivas);
		return "subjetiva/subjetivas.html";
	}

	@PostMapping("/save")
	public String save(@Valid QuestaoSubjetiva subjetivas, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "subjetiva/subjetivas.html";
		}dao.save(subjetivas);
		return "redirect:/questaoSubjetiva/listSubjetivas";
	}

}
