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
@Table(name = "users") // en caso que la tabala sea diferente
public class User {

	//Atributos de entidad User
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "userName")//no hace falta si se llama igual
	private String username;
	@Column(name = "email")//no hace falta si se llama igual
	private String email;
	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name="rol")
	private Role rol;
	
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Order> order;
	// Constructores

	public User() {}

	public User(Long id, String username, String email, Role rol,List<Order> order, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.rol = rol;
		this.order = order;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRol() {
		return rol;
	}

	public void setRol(Role rol) {
		this.rol = rol;
	}


	@JsonIgnore
	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", rol="
				+ rol + ", order=" + order + "]";
	}

	

}