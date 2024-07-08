package it.vitali.pizzeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.vitali.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
	
	List<Pizza> findByNome(String nome);

}
