package com.pacoteck.springboot.app.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dishs")
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="namee")
	private String name;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "category")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "alergeno")
	private Alergeno alergeno;
	
	//connection
	
	@OneToMany(mappedBy = "dish")
	private List<DishOrder> dishOrder;
	
	public Dish() {}

	public Dish(Long id, String name, String img, double price, Category category, Alergeno alergeno,
			List<DishOrder> dishOrder) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.price = price;
		this.category = category;
		this.alergeno = alergeno;
		this.dishOrder = dishOrder;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@JsonIgnore
	public List<DishOrder> getDishOrder() {
		return dishOrder;
	}

	public void setDishOrder(List<DishOrder> dishOrder) {
		this.dishOrder = dishOrder;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Alergeno getAlergeno() {
		return alergeno;
	}

	public void setAlergeno(Alergeno alergeno) {
		this.alergeno = alergeno;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", img=" + img + ", category=" + category + "]";
	}
	
	
}
