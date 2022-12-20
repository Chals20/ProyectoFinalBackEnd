package com.pacoteck.springboot.app.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders") // en caso que la tabala sea diferente
public class Order {

	//Atributos de entidad Order
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;

	@Column(name="fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	//connection
	@ManyToOne
	@JoinColumn(name = "users")
	private User user;
	
	 @Column(name = "hora")
	 private double hora;
	 
	 @Column(name= "total")
	 private double total;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<DishOrder> dishOrder;
	
	
	// Constructores

	public Order() {

	}

	public Order(Long id, Date date, User user,
			List<DishOrder> dishorder,double hora,double total) {
		this.id = id;
		this.date = date;
		this.user = user;
		this.dishOrder = dishorder;
		this.hora = hora;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUsers() {
		return user;
	}

	public void setUsers(User users) {
		this.user = users;
	}

	@JsonIgnore
	public List<DishOrder> getDishOrder() {
		return dishOrder;
	}

	public void setDishOrder(List<DishOrder> dishOrder) {
		this.dishOrder = dishOrder;
	}

	public double getHora() {
		return hora;
	}

	public void setHora(double hora) {
		this.hora = hora;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


}