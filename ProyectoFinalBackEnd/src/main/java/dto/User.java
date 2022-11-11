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
@Table(name = "User") // en caso que la tabala sea diferente
public class User {

	//Atributos de entidad User
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "username")//no hace falta si se llama igual
	private String username;
	@Column(name = "email")//no hace falta si se llama igual
	private String email;
	@Column(name = "idRole")//no hace falta si se llama igual
	private long idRole;
	

	// Constructores

	public User() {

	}

	/**
	 * @param id
	 * @param username
	 * @param email
	 * @param idRole
	 */
	public User(Long id, String username, String email, long idRole) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.idRole = idRole;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the idRole
	 */
	public long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	
	@Override
	public String toString() {
		return "User [id =" + id + ", username =" + username + ", email =" + email + ", idRole =" + idRole + "]";
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}