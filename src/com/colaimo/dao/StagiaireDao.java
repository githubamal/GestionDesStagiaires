package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.colaimo.model.Stagiaire;
import com.colaimo.util.DBUtil;

public class StagiaireDao {
	
	private Connection connection;

	public StagiaireDao() {
		connection = DBUtil.getConnection();
}
	
	/**
	 * Ajouter un Stagiaire
	 * @param stagiaire
	 */
	public void ajouterEncadrant(Stagiaire stagiaire) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into stagiaire(nom,prenom,dat_naiss,lieu_naissance,ville,telephone,email,cin) values (?, ?, ?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1,stagiaire.getNom());
			preparedStatement.setString(2, stagiaire.getPrenom());
			preparedStatement.setDate(3, new java.sql.Date(stagiaire.getDateNaissance().getTime()));
			preparedStatement.setString(4, stagiaire.getLieuNaissance());
			preparedStatement.setString(5, stagiaire.getVille());
			preparedStatement.setString(6, stagiaire.getTelephone());
			preparedStatement.setString(7, stagiaire.getEmail());
			preparedStatement.setInt(8, stagiaire.getCin());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Supprimer un stagiaire
	 * @param stagiaireId
	 */
	public void deleteStagiaire(int stagiaireId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from stagiaire where id_stagiaire=?");
			// Parameters start with 1
			preparedStatement.setInt(1, stagiaireId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * mettre à jour un stagiaire
	 * @param encadrant
	 */
	public void updateStagiaire(Stagiaire stagiaire) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update stagiare set nom=?, prenom=?,dat_naiss=?,lieu_naissance=?,ville=?,telephone=?,email=?, cin=?" +
							"where id_stagiaire=?");
			// Parameters start with 1
			preparedStatement.setString(1, stagiaire.getNom());
			preparedStatement.setString(2, stagiaire.getPrenom());
			preparedStatement.setDate(3, new java.sql.Date(stagiaire.getDateNaissance().getTime()));
			preparedStatement.setString(4, stagiaire.getLieuNaissance());
			preparedStatement.setString(5, stagiaire.getVille());
			preparedStatement.setString(6, stagiaire.getTelephone());
			preparedStatement.setString(7, stagiaire.getEmail());
			preparedStatement.setInt(8, stagiaire.getCin());
			preparedStatement.setInt(9, stagiaire.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * recuperer tout les stagiaires
	 * @return
	 */
	public List<Stagiaire> getAllStagiaire() {
		List<Stagiaire> listStagiaire= new ArrayList<Stagiaire>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from stagiaire");
			while (rs.next()) {
				Stagiaire stagiaire = new Stagiaire();
				stagiaire.setId(rs.getInt("id_stagiaire"));
				stagiaire.setNom(rs.getString("nom"));
				stagiaire.setPrenom(rs.getString("prenom"));
				stagiaire.setDateNaissance(rs.getDate("dat_naiss"));
				stagiaire.setLieuNaissance(rs.getString("lieu_naissance"));
				stagiaire.setVille(rs.getString("ville"));
				stagiaire.setTelephone(rs.getString("telephone"));
				stagiaire.setEmail(rs.getString("email"));
				stagiaire.setCin(rs.getInt("cin"));
				listStagiaire.add(stagiaire);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listStagiaire;
	}
	
	/**
	 * recuperer stagiaire par Id
	 * @param stagiaireId
	 * @return
	 */
	public Stagiaire getStagiaireById(int stagiaireId) {
		Stagiaire stagiaire = new Stagiaire();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from stagiaire where id_stagiaire=?");
			preparedStatement.setInt(1, stagiaireId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				stagiaire.setId(rs.getInt("id_encadrant"));
				stagiaire.setNom(rs.getString("nom"));
				stagiaire.setPrenom(rs.getString("prenom"));
				stagiaire.setDateNaissance(rs.getDate("date_naiss"));
				stagiaire.setLieuNaissance(rs.getString("lieu_naissance"));
				stagiaire.setVille(rs.getString("ville"));
				stagiaire.setTelephone(rs.getString("telephone"));
				stagiaire.setEmail(rs.getString("email"));
				stagiaire.setCin(rs.getInt("cin"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stagiaire;
	}
}
