package it.vitali.pizzeria.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="offerta_speciale")
public class OffertaSpeciale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="inizio_offerta", nullable=false)
	private LocalDateTime dataInizioOfferta;
	
	@Column(name="fine_offerta", nullable=false)
	private LocalDateTime dataFineOfferta;
	
	@Column(name="nome_offerta")
	private String nomeOfferta;
	
	@ManyToOne
	@JoinColumn(name="pizza_id", nullable=false)
	private Pizza pizza;
	
	
	
	//costruttore vuoto
	
	// GETTER E SETTER

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataInizioOfferta() {
		return dataInizioOfferta;
	}

	public void setDataInizioOfferta(LocalDateTime dataInizioOfferta) {
		this.dataInizioOfferta = dataInizioOfferta;
	}

	public LocalDateTime getDataFineOfferta() {
		return dataFineOfferta;
	}

	public void setDataFineOfferta(LocalDateTime dataFineOfferta) {
		this.dataFineOfferta = dataFineOfferta;
	}	
	
	public String getNomeOfferta() {
		return nomeOfferta;
	}

	public void setNomeOfferta(String nomeOfferta) {
		this.nomeOfferta = nomeOfferta;
	}


	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	

	
	

}
