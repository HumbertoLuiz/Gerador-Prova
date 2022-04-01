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

import br.edu.ifpr.app.sae.model.Alternativa;
import br.edu.ifpr.app.sae.model.QuestaoObjetiva;
import br.edu.ifpr.app.sae.repository.QuestaoObjetivaRepository;
import br.edu.ifpr.app.sae.service.QuestaoObjetivaService;

@Controller
@RequestMapping("/questaoObjetiva")
public class QuestaoObjetivaController {
	
	@Autowired
	QuestaoObjetivaRepository dao;
	
	@Autowired
	QuestaoObjetivaService questaoObjetivaService;
	
	@RequestMapping("/new")
	public String index(Model model) {
		model.addAttribute("questaoObjetiva", questaoObjetivaService.createQuestao());
		return "objetiva/objetivas.html";
	}
	
	@GetMapping("/listObjetivas")
	public String list(Model model) {
		model.addAttribute("objetivasList", dao.findAll());
		return "objetiva/listObjetivas.html";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.removerQuestaoObjetiva(id);
		return "redirect:/questaoObjetiva/listObjetivas";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		QuestaoObjetiva questaoOjetiva = dao.findById(id).get();
		model.addAttribute("questaoObjetiva", questaoOjetiva);
		return "objetiva/objetivas.html";
	}

	@PostMapping("/save")
	public String save(@Valid QuestaoObjetiva questaoObjetiva, BindingResult result, Model model) {
		int i =1;
		if (result.hasErrors()) {
			return "objetiva/listObjetivas.html";
		}else {
			for(Alternativa cntc: questaoObjetiva.getAlternativaList()) {
				cntc.setSequenceNumber(i);
				i++;
			}
			model.addAttribute("questaoObjetiva", questaoObjetivaService.saveQuestao(questaoObjetiva));
		}
	
		return "redirect:/questaoObjetiva/listObjetivas";
	}

	@PostMapping("/addRow")
	public String addRow(QuestaoObjetiva questaoObjetiva) {
		questaoObjetivaService.addRow(questaoObjetiva);
		return "objetiva/objetivas :: alternativas"; 
	}
}
