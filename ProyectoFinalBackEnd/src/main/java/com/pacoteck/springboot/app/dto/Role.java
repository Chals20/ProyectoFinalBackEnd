package com.pacoteck.springboot.app.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles") // en caso que la tabala sea diferente
public class Role {

	// Atributos de entidad Role
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "name") // no hace falta si se llama igual
	private String name;
	
	@OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
	private List<User> user;

	// Constructores

	public Role() {}

	public Role(Long id, String name, List<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
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
	public List<User> getUser() {
		return user;
	}



	public void setUser(List<User> user) {
		this.user = user;
	}



	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Role [id =" + id + ", name =" + name + "]";
	}

}