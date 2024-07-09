package it.vitali.pizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.vitali.pizzeria.model.Pizza;
import it.vitali.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/pizzeria")
public class PizzaController {
	
	@Autowired
	private PizzaRepository repository;
	
	@GetMapping
	public String index(Model model, @RequestParam(name="nome", required = false) String nome) {
		
		List <Pizza> pizze = new ArrayList<>();
		
		
		if(nome == null || nome.isBlank()) {
			pizze = repository.findAll();
		} else {
			pizze = repository.findByNome(nome);
		}
		
		model.addAttribute("list", pizze);	
		return "/pizzeria/index";
		
	}	
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer pizzaId, Model model) {
		
		model.addAttribute("pizza", repository.getReferenceById(pizzaId));
		return "pizzeria/show";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		return "pizzeria/create";
	}
	

//fine classe
}
