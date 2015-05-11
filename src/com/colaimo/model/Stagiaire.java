package com.colaimo.model;

import java.util.Date;

public class Stagiaire {

	Integer id;
	String nom;
	String prenom;
	Date dateNaissance;
	
	
	/**
	 * abdimostapha@gmail.com
	 * get id
	 * @return integer
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
	
}
