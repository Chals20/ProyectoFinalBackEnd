package com.pacoteck.springboot.app.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="alergenos")
public class Alergeno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	@Column(name="lacteos")
	private boolean lacteos;
	
	@Column(name="gluten")
	private boolean gluten;
	
	@Column(name="vegan")
	private boolean vegan;
	
	@OneToMany(mappedBy = "alergeno")
	private List<Dish> dishes;
	
	public Alergeno() {}

	public Alergeno(Long id, boolean lacteos, boolean gluten, boolean vegan, List<Dish> dishes) {
		this.id = id;
		this.lacteos = lacteos;
		this.gluten = gluten;
		this.vegan = vegan;
		this.dishes = dishes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isLacteos() {
		return lacteos;
	}

	public void setLacteos(boolean lacteos) {
		this.lacteos = lacteos;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	@JsonIgnore
	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	
	
}
