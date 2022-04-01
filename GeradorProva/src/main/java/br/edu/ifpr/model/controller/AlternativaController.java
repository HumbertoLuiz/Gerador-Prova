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
import br.edu.ifpr.model.Alternativas;
import br.edu.ifpr.repository.AlternativasRepository;

@Controller
@RequestMapping("/alternativas")
public class AlternativaController {

	@Autowired
	AlternativasRepository dao;


	@GetMapping("/alternativas")
	public String newForm(Model model) {
		Alternativas alt = new Alternativas();
		model.addAttribute("alternativas", alt);
		return "alternativas/alternativas.html";
	}

	@GetMapping("/listAlternativas")
	public String list(Model model) {
		model.addAttribute("alternativasList", dao.findAll());
		return "alternativas/alternativas.html";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		dao.removerAlternativa(id);
		return "redirect:/alternativas/listAlternativas";
	}

	public String edit(@PathVariable Integer id, Model model) {

		Optional<Alternativas> alt = dao.findById(id);
		
		if (!alt.isPresent()) {
			throw new IllegalArgumentException("Inválido.");
		}
		model.addAttribute("alt", alt.get());

		return "alternativas/listAlternativas.html";

	}

	@PostMapping("/save")
	public String save(@Valid Alternativas alt, BindingResult result, Model model) {
		if (result.hasErrors())
			return "alternativas/alternativas.html";
		dao.save(alt);
		return "redirect:/alternativas/alternativas";
	}
	
}
