package com.colaimo.model;

public class Formation {

	Integer id;
	String etablissement;
	String diplome;
	String filiere;

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
	 * @return the etablissement
	 */
	public String getEtablissement() {
		return etablissement;
	}

	/**
	 * @param etablissement
	 *            the etablissement to set
	 */
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	/**
	 * @return the diplome
	 */
	public String getDiplome() {
		return diplome;
	}

	/**
	 * @param diplome
	 *            the diplome to set
	 */
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	/**
	 * @return the filiere
	 */
	public String getFiliere() {
		return filiere;
	}

	/**
	 * @param filiere
	 *            the filiere to set
	 */
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

}
