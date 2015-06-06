package com.colaimo.model;

public class Encadrant {

	Integer id;
	String nomE;
	String prenomE;
	String email;
	String telephone;
	/**
	 * @return the nomE
	 */
	public String getNomE() {
		return nomE;
	}

	/**
	 * @param nomE the nomE to set
	 */
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}

	/**
	 * @return the prenomE
	 */
	public String getPrenomE() {
		return prenomE;
	}

	/**
	 * @param prenomE the prenomE to set
	 */
	public void setPrenomE(String prenomE) {
		this.prenomE = prenomE;
	}

	String login;
	String password;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
