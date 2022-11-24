package com.pacoteck.springboot.app.dto;

import java.util.Date;
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
	private User users;
	
	@OneToMany(mappedBy = "order")
	private List<DishOrder> dishOrder;
	
	// Constructores

	public Order() {

	}

	public Order(Long id, Date date, User user, List<DishOrder> dishorder) {
		super();
		this.id = id;
		this.date = date;
		this.users = user;
		this.dishOrder = dishorder;
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



	public User getUser() {
		return users;
	}



	public void setUser(User user) {
		this.users = user;
	}


	@JsonIgnore
	public List<DishOrder> getDishorder() {
		return dishOrder;
	}



	public void setDishorder(List<DishOrder> dishorder) {
		this.dishOrder = dishorder;
	}



	@Override
	public String toString() {
		return "Order [id =" + id + ", idUser =" + users.getUsername() + ", date =" + date + "]";
	}


	

}