package it.vitali.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		
		return"redirect:/pizzeria/show" + offerta.getPizza().getId();
	}
	
	
	
	
	


}
