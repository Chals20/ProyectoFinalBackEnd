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
@Table(name = "Order") // en caso que la tabala sea diferente
public class Order {

	//Atributos de entidad Order
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "idUser")//no hace falta si se llama igual
	private long idUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	

	// Constructores

	public Order() {

	}

	

	/**
	 * @param id
	 * @param idUser
	 * @param date
	 */
	public Order(Long id, long idUser, Date date) {
		this.id = id;
		this.idUser = idUser;
		this.date = date;
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
	 * @return the idUser
	 */
	public long getIdUser() {
		return idUser;
	}
	
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "Order [id =" + id + ", idUser =" + idUser + ", date =" + date + "]";
	}


	

}