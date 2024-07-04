package it.vitali.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.vitali.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {

}
