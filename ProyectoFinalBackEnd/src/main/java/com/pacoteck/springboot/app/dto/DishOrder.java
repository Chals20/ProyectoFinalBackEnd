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
	 private Order order;
	 

	 @ManyToOne
	 @JoinColumn(name="dish")
	 private Dish dish;
	 
	 @Column(name="amount")
	 private int amount;


	public DishOrder() {
		super();
	}


	public DishOrder(Long id, Order orden, Dish dish, int amount) {
		this.id = id;
		this.order = orden;
		this.dish = dish;
		this.amount = amount;
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


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
