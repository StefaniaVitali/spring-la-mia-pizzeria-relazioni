package it.vitali.pizzeria.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.vitali.pizzeria.model.OffertaSpeciale;
import it.vitali.pizzeria.model.Pizza;
import it.vitali.pizzeria.repository.OffertaSpecialeRepository;
import it.vitali.pizzeria.repository.PizzaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pizzeria")
public class PizzaController {
	
	@Autowired
	private PizzaRepository repository;
	
	@Autowired
	private OffertaSpecialeRepository offertaRepository;	
	
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
		
	//	Pizza pizza = repository.getReferenceById(pizzaId);
	//	pizza.getOffertaSpeciale()
		model.addAttribute("pizza", repository.getReferenceById(pizzaId));
		return "pizzeria/show";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		model.addAttribute("pizza", new Pizza()); //-> Questo è il costruttore vuoto
		
		return "pizzeria/create";
	}
	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model ) {
		
		
		
		if(bindingResult.hasErrors()) {
			return "pizzeria/create";
		}
		
		repository.save(formPizza);
		
		return "redirect:/pizzeria";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("pizza", repository.findById(id).get());
		
		return "pizzeria/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model ) {
		
		
		
		if(bindingResult.hasErrors()) {
			return "pizzeria/edit";
		}
		
		repository.save(formPizza);
		
		return "redirect:/pizzeria";
	}
	
	@PostMapping("/delete/{id}")
	public String delete (@PathVariable("id") Integer id) {
		
		repository.deleteById(id);
		
		return "redirect:/pizzeria";
		
	}
	
	@GetMapping("/{id}/offer")
	public String offer(@PathVariable("id") Integer id, Model model) {
		
		Pizza pizza = repository.findById(id).get();
		OffertaSpeciale offerta = new OffertaSpeciale();
		offerta.setNomeOfferta("Sconto poraccio");
		offerta.setDataInizioOfferta(LocalDateTime.now());
		offerta.setPizza(pizza);
		
		model.addAttribute("offerta", offerta);
		
		return "offerte/edit";
		
	}



//fine classe
}
