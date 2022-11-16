package com.pacoteck.springboot.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dishOrder")
public class DishOrder {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @ManyToOne
	 @JoinColumn(name="order")
	 private Order order;
	 

	 @ManyToOne
	 @JoinColumn(name="dish")
	 private Dish dish;


	public DishOrder() {
		super();
	}
	 

}
