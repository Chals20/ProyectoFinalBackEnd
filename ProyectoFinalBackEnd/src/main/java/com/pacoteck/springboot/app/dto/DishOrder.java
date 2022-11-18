package com.pacoteck.springboot.app.dto;

import javax.persistence.*;

@Entity
@Table(name="dishOrder")
public class DishOrder {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @ManyToOne
	 @JoinColumn(name="orden")
	 private Order orden;
	 

	 @ManyToOne
	 @JoinColumn(name="dish")
	 private Dish dish;


	public DishOrder() {
		super();
	}


	public DishOrder(Long id, Order orden, Dish dish) {
		super();
		this.id = id;
		this.order = orden;
		this.dish = dish;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Order getOrden() {
		return order;
	}


	public void setOrden(Order orden) {
		this.order = orden;
	}


	public Dish getDish() {
		return dish;
	}


	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
}
