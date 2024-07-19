package it.vitali.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.vitali.pizzeria.model.Ingrediente;
import it.vitali.pizzeria.repository.IngredienteRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@GetMapping()
	public String index(Model model) {
		
		model.addAttribute("listaIngredienti", ingredienteRepository.findAll());
		model.addAttribute("ingrediente",  new Ingrediente());
		return "ingredienti/index";
	}
	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, Model model, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "ingredienti/index";
		}		
		ingredienteRepository.save(ingrediente);
		return "ingredienti/index";
	}
	
	
//fine classe
}
