package it.vitali.pizzeria.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;


@Entity
@Table(name = "pizza")
public class Pizza {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="il campo nome deve essere compilato")
	@Size(max=50)
	private String nome;
	
	@NotBlank(message="il campo descrizione deve essere compilato")
	private String descrizione;
	
	@Column(name = "immagine")
	private String url;
	
	@NotNull(message= "il campo prezzo deve essere compilato")
	private float prezzo;	
	
	@OneToMany(mappedBy= "pizza")
	private List <OffertaSpeciale> offerteSpeciali;
	
	@ManyToMany()
	@JoinTable(
			name="pizza_ingredienti",
			joinColumns = @JoinColumn(name="pizza_id"),
			inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
			)
	private List<Ingrediente> ingredienti;
	
	
	//GETTER E SETTER
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public List<OffertaSpeciale> getOffertaSpeciale() {
		return offerteSpeciali;
	}
	public void setOffertaSpeciale(List<OffertaSpeciale> offerteSpeciali) {
		this.offerteSpeciali = offerteSpeciali;
	}
	
	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}
	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	
	
	
	
// fine classe
}
