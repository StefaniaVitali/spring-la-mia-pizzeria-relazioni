package it.vitali.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.vitali.pizzeria.model.OffertaSpeciale;
import it.vitali.pizzeria.repository.OffertaSpecialeRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaSpecialeController {
	
	@Autowired
	private OffertaSpecialeRepository offertaRepository;
	
	@PostMapping("/create")
	public String store (@ModelAttribute("offerta") OffertaSpeciale offerta, Model model , BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors()) {
			return "offerte/edit";
		}
		
		offertaRepository.save(offerta);
		
		return"redirect:/pizzeria/show/" + offerta.getPizza().getId();
	}
	
   
	@GetMapping("/edit/{id}")
   public String edit (@PathVariable("id") Integer idOfferta, Model model) {
		
		OffertaSpeciale offerta = offertaRepository.findById(idOfferta).get();
		
		model.addAttribute("offerta", offerta);
		model.addAttribute("editMode", true);
		
		return "offerte/edit";
	}
	
	
	
	
	

//fine classe
}
