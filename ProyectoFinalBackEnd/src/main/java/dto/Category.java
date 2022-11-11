package dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Category") // en caso que la tabala sea diferente
public class Category {

	// Atributos de entidad Category
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "name") // no hace falta si se llama igual
	private String name;

	// Constructores

	public Category() {

	}

	/**
	 * @param id
	 * @param name
	 */
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getters y Setters

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Category [id =" + id + ", name =" + name + "]";
	}

}