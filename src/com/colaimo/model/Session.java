package com.colaimo.model;

import java.util.Date;

public class Session {

	Integer id;
	Date datDebut;
	Date datFin;

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
	 * @return the datDebut
	 */
	public Date getDatDebut() {
		return datDebut;
	}

	/**
	 * @param datDebut
	 *            the datDebut to set
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
	 * @param datFin
	 *            the datFin to set
	 */
	public void setDatFin(Date datFin) {
		this.datFin = datFin;
	}

}
