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
import br.edu.ifpr.model.RealizarProva;
import br.edu.ifpr.repository.RealizarProvaRepository;

@Controller
@RequestMapping("/realizar")
public class RealizarProvaController {

	@Autowired
	RealizarProvaRepository dao;


	@GetMapping("/realizarProva")
	public String newForm(Model model) {
		RealizarProva rp = new RealizarProva();
		model.addAttribute("realizar", rp);
		return "realizarProva/realizarProva.html";
	}

	@GetMapping("/listRalizada")
	public String list(Model model) {
		model.addAttribute("realizadaList", dao.findAll());
		return "realizarProva/realizarProva.html";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		dao.removerRealizada(id);
		return "redirect:/realizar/listRealizada";
	}

	public String edit(@PathVariable Integer id, Model model) {

		Optional<RealizarProva> rp = dao.findById(id);
		
		if (!rp.isPresent()) {
			throw new IllegalArgumentException("Inválido.");
		}
		model.addAttribute("rp", rp.get());

		return "cadastrarQuestoes/listQuestoes.html";

	}

	@PostMapping("/save")
	public String save(@Valid RealizarProva rp, BindingResult result, Model model) {
		if (result.hasErrors())
			return "realizarProva/realizarProva.html";
		dao.save(rp);
		return "redirect:/realizar/realizarProva";
	}
}

	

