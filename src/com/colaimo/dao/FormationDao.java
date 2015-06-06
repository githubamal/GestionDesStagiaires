package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.model.Formation;
import com.colaimo.util.DBUtil;

public class FormationDao {

	private Connection connection;

	public FormationDao() {
		connection = DBUtil.getConnection();
	}

	/**
	 * Ajouter une formation
	 * 
	 * @param encadrant
	 */
	public void ajouterFormation(Formation formation) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into formation(etablissement,diplome,filiere) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, formation.getEtablissement());
			preparedStatement.setString(2, formation.getFiliere());
			preparedStatement.setString(3, formation.getDiplome());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * suppression formation
	 * 
	 * @param encadrantId
	 */
	public void deleteFormation(int formationId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from formation where id_form=?");
			// Parameters start with 1
			preparedStatement.setInt(1, formationId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mis à jour formation
	 * 
	 * @param formation
	 */
	public void updateFormation(Formation formation) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update formation set etablissement=?, diplome=?, filiere=?"
							+ "where id_form=?");
			// Parameters start with 1
			preparedStatement.setString(1, formation.getEtablissement());
			preparedStatement.setString(2, formation.getDiplome());
			preparedStatement.setString(3, formation.getFiliere());
			preparedStatement.setInt(4, formation.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * recuperer tout les formations
	 * 
	 * @return
	 */
	public List<Formation> getAllFormation() {
		List<Formation> listFormation = new ArrayList<Formation>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from formation");
			while (rs.next()) {
				Formation formation = new Formation();
				formation.setId(rs.getInt("id_form"));
				formation.setEtablissement(rs.getString("etablissement"));
				formation.setDiplome(rs.getString("diplome"));
				formation.setFiliere(rs.getString("filiere"));
				listFormation.add(formation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listFormation;
	}
	
	/**
	 * Recuperer tout les formations
	 * @return
	 */
	public List<Formation> chercherFormation(Formation pFormation) {
		List<Formation> listFormation = new ArrayList<Formation>();
		try {

			String requete = "select * from formation WHERE 1=1 ";
			if (StringUtils.isNotBlank(pFormation.getEtablissement())) {
				requete += " AND etablissement= '" + pFormation.getEtablissement() + "' ";
			}
			if (StringUtils.isNotBlank(pFormation.getDiplome())) {
				requete += " AND diplome= '" + pFormation.getDiplome() + "' ";
			}
			if (StringUtils.isNotBlank(pFormation.getFiliere())) {
				requete += " AND filiere= '" + pFormation.getFiliere() + "' ";
			}
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			while (rs.next()) {
				Formation formation = new Formation();
				formation.setId(rs.getInt("id_formation"));
				formation.setEtablissement(rs.getString("etablissement"));
				formation.setDiplome(rs.getString("diplome"));
				formation.setFiliere(rs.getString("filiere"));
				listFormation.add(formation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listFormation;
	}

	/**
	 * recuperer formation par Id
	 * 
	 * @param formationId
	 * @return
	 */
	public Formation getFormationById(int formationId) {
		Formation formation = new Formation();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from formation where id_form=?");
			preparedStatement.setInt(1, formationId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				formation.setId(rs.getInt("id_form"));
				formation.setEtablissement(rs.getString("etablissement"));
				formation.setDiplome(rs.getString("diplome"));
				formation.setFiliere(rs.getString("filiere"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return formation;
	}

}
