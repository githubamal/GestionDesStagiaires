package com.colaimo.model;

import java.util.Date;

public class Stage {

	Integer id;
	String intituleStage;
	Date datDebut;
	Date datFin;
	String theme;
	

	/**
	 * @return the datDebut
	 */
	public Date getDatDebut() {
		return datDebut;
	}

	/**
	 * @param datDebut the datDebut to set
	 */
	public void setDatDebut(Date datDebut) {
		this.datDebut = datDebut;
	}

	/**
	 * @return the datFin
	 */
	public Date getDatFin() {
		return datFin;
	}

	/**
	 * @param datFin the datFin to set
	 */
	public void setDatFin(Date datFin) {
		this.datFin = datFin;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

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
	 * @return the intituleStage
	 */
	public String getIntituleStage() {
		return intituleStage;
	}

	/**
	 * @param intituleStage
	 *            the intituleStage to set
	 */
	public void setIntituleStage(String intituleStage) {
		this.intituleStage = intituleStage;
	}

}
