package it.vitali.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.vitali.pizzeria.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{

}
