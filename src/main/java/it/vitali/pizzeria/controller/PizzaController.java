package it.vitali.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.vitali.pizzeria.model.Pizza;
import it.vitali.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/pizzeria")
public class PizzaController {
	
	@Autowired
	private PizzaRepository repository;
	
	@GetMapping
	public String index(Model model) {
		
		List <Pizza> pizze = repository.findAll();
		
		model.addAttribute("list", pizze);		
		
		return "/pizzeria/index";
		
	}

//fine classe
}
