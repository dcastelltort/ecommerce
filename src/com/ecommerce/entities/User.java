/**
 * 
 */
package com.ecommerce.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author shenten
 *
 */
@Entity //make it an EJB Entity
public class User {

	@Id // Id flag and auto generated
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long	id;
	private String	name;
	private String	password;
	private String	email;
	private Timestamp signUpDate; 
	
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the signUpDate
	 */
	public Timestamp getSignUpDate() {
		return signUpDate;
	}
	/**
	 * @param signUpDate the signUpDate to set
	 */
	public void setSignUpDate(Timestamp signUpDate) {
		this.signUpDate = signUpDate;
	}
}
