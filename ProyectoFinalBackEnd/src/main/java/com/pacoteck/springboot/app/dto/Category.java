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
@Table(name = "categorys") // en caso que la tabala sea diferente
public class Category {

	// Atributos de entidad Category
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Long id;
	
	@Column(name = "namee") // no hace falta si se llama igual
	private String name;
	
	
	@OneToMany(mappedBy = "category")
	private List<Dish> dish;
	
	// Constructores

	public Category() {

	}

	public Category(Long id, String name, List<Dish> dish) {
		super();
		this.id = id;
		this.name = name;
		this.dish = dish;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<Dish> getDish() {
		return dish;
	}

	public void setDish(List<Dish> dish) {
		this.dish = dish;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Category [id =" + id + ", name =" + name + "]";
	}

}