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

import br.edu.ifpr.model.Prova;
import br.edu.ifpr.model.Questao;
import br.edu.ifpr.repository.ProvaRepository;


@Controller
@RequestMapping("/gerar")
public class ProvaController {

	@Autowired
	ProvaRepository dao;

	@GetMapping("/gerarProva")
	public String newForm(Model model) {
		Prova p = new Prova();
		model.addAttribute("prova", p);
		return "gerarProva/gerarProva.html";
	}
	
	@GetMapping("/listProvas")
	public String list(Model model) {
		model.addAttribute("provasList", dao.findAll());
		return "gerar/listProvas.html";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		dao.removerProva(id);
		return "redirect:/gerar/listProvas";
	}

	public String edit(@PathVariable Integer id, Model model) {

		Optional<Prova> prova = dao.findById(id);
		
		if (!prova.isPresent()) {
			throw new IllegalArgumentException("Inválido.");
		}
		model.addAttribute("prova", prova.get());

		return "gerarProva/gerarProva.html";

	}

	@PostMapping("/save")
	public String save(@Valid Prova prova, BindingResult result, Model model) {
		if (result.hasErrors())
			return "gerarProva/gerarProva.html";
		dao.save(prova);
		return "redirect:/gerar/listProvas";
	}
	
}
