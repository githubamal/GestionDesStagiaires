package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.model.Stagiaire;
import com.colaimo.util.DBUtil;

public class StagiaireDao {
	
	private Connection connection;

	public StagiaireDao() {
		connection = DBUtil.getConnection();
}
	
	/**
	 * Ajouter un Stagiaire
	 * 
	 * @param stagiaire
	 */
	public void ajouterStagiaire(Stagiaire stagiaire) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into stagiaire(nom,prenom,date_naissance,lieu_naissance,ville,telephone,email,cin, id_formation) values (?, ?, ?, ?, ?, ?, ?, ?, ?  )");
			// Parameters stagiaires
			preparedStatement.setString(1,stagiaire.getNom());
			preparedStatement.setString(2, stagiaire.getPrenom());
			preparedStatement.setString(3, stagiaire.getDateNaissance());
			preparedStatement.setString(4, stagiaire.getLieuNaissance());
			preparedStatement.setString(5, stagiaire.getVille());
			preparedStatement.setString(6, stagiaire.getTelephone());
			preparedStatement.setString(7, stagiaire.getEmail());
			preparedStatement.setString(8, stagiaire.getCin());
			preparedStatement.setString(9, stagiaire.getIdFormation());
			preparedStatement.executeUpdate();
		
			PreparedStatement preparedStatementSession = connection
					.prepareStatement("insert into session(id_stagiaire, id_encadrant, id_theme,  dat_debut, dat_fin) values (?, ?, ?, ?, ?)");
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MAX(id_stagiaire) as id FROM stagiaire ");
			while (rs.next()) {
				int id = rs.getInt("id");
				// Parameters session
				preparedStatementSession.setInt(1, id);
				preparedStatementSession.setInt(2, Integer.valueOf(stagiaire.getIdEncadrant()));
				preparedStatementSession.setInt(3, Integer.valueOf(stagiaire.getIdtheme()));
				preparedStatementSession.setString(4, stagiaire.getDateDebut());
				preparedStatementSession.setString(5, stagiaire.getDateFin());
				preparedStatementSession.executeUpdate();
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Supprimer un stagiaire
	 * 
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
					.prepareStatement("update stagiaire set nom=?, prenom=?,date_naissance=?,lieu_naissance=?,ville=?,telephone=?,email=?, cin=?" +
							"where id_stagiaire=?");
			// Parameters start with 1
			preparedStatement.setString(1, stagiaire.getNom());
			preparedStatement.setString(2, stagiaire.getPrenom());
			preparedStatement.setDate(3, null);
			preparedStatement.setString(4, stagiaire.getLieuNaissance());
			preparedStatement.setString(5, stagiaire.getVille());
			preparedStatement.setString(6, stagiaire.getTelephone());
			preparedStatement.setString(7, stagiaire.getEmail());
			preparedStatement.setString(8, stagiaire.getCin());
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
			ResultSet rs = statement.executeQuery("select * from stagiaire, session, encadrant,  theme"
					+ " where stagiaire.id_stagiaire = session.id_stagiaire "
					+ "and encadrant.id_encadrant = session.id_encadrant "
					+ "and theme.id_theme = session.id_theme");
			while (rs.next()) {
				Stagiaire stagiaire = new Stagiaire();
				stagiaire.setId(rs.getInt("stagiaire.id_stagiaire"));
				stagiaire.setNom(rs.getString("stagiaire.nom"));
				stagiaire.setPrenom(rs.getString("stagiaire.prenom"));
				stagiaire.setDateNaissance(rs.getString("stagiaire.date_naissance"));
				stagiaire.setLieuNaissance(rs.getString("stagiaire.lieu_naissance"));
				stagiaire.setVille(rs.getString("stagiaire.ville"));
				stagiaire.setTelephone(rs.getString("stagiaire.telephone"));
				stagiaire.setEmail(rs.getString("stagiaire.email"));
				stagiaire.setCin(rs.getString("stagiaire.cin"));
				stagiaire.setNomEncadrant(rs.getString("encadrant.nom_encadrant"));
				stagiaire.setTheme(rs.getString("theme.theme"));
				stagiaire.setDateDebut(rs.getString("session.dat_debut"));
				stagiaire.setDateFin(rs.getString("session.dat_fin"));
				listStagiaire.add(stagiaire);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listStagiaire;
	}
	/**
	 * recuperer tout les stagiaires
	 * @return
	 */
	public List<Stagiaire> chercherStagiaires(Stagiaire pStagiaire) {
		List<Stagiaire> listStagiaire = new ArrayList<Stagiaire>();
		try {

			String requete = "select * from stagiaire, session, encadrant,  theme"
					+ " where stagiaire.id_stagiaire = session.id_stagiaire "
					+ "and encadrant.id_encadrant = session.id_encadrant "
					+ "and theme.id_theme = session.id_theme";
			if (StringUtils.isNotBlank(pStagiaire.getNom())) {
				requete += " AND nom= '" + pStagiaire.getNom() + "' ";
			}
			if (StringUtils.isNotBlank(pStagiaire.getPrenom())) {
				requete += " AND prenom= '" + pStagiaire.getPrenom() + "' ";
			}
			// if(StringUtils.isNotBlank(pStagiaire.getDateNaissance()))
			// {
			// requete +=
			// " AND date_naissance= '"+pStagiaire.getDateNaissance()+"' ";
			// }
			if (StringUtils.isNotBlank(pStagiaire.getLieuNaissance())) {
				requete += " AND lieu_naissance= '"
						+ pStagiaire.getLieuNaissance() + "' ";
			}
			if (StringUtils.isNotBlank(pStagiaire.getVille())) {
				requete += " AND ville= '" + pStagiaire.getVille() + "' ";
			}
			if (StringUtils.isNotBlank(pStagiaire.getTelephone())) {
				requete += " AND telephone= '" + pStagiaire.getTelephone()
						+ "' ";
			}
			if (StringUtils.isNotBlank(pStagiaire.getCin())) {
				requete += " AND cin= '" + pStagiaire.getCin() + "' ";
			}
			if (StringUtils.isNotBlank(pStagiaire.getEmail())) {
				requete += " AND email= '" + pStagiaire.getEmail() + "' ";
			}

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			while (rs.next()) {
				Stagiaire stagiaire = new Stagiaire();
				stagiaire.setId(rs.getInt("stagiaire.id_stagiaire"));
				stagiaire.setNom(rs.getString("stagiaire.nom"));
				stagiaire.setPrenom(rs.getString("stagiaire.prenom"));
				stagiaire.setDateNaissance(rs.getString("stagiaire.date_naissance"));
				stagiaire.setLieuNaissance(rs.getString("stagiaire.lieu_naissance"));
				stagiaire.setVille(rs.getString("stagiaire.ville"));
				stagiaire.setTelephone(rs.getString("stagiaire.telephone"));
				stagiaire.setEmail(rs.getString("stagiaire.email"));
				stagiaire.setCin(rs.getString("stagiaire.cin"));
				stagiaire.setNomEncadrant(rs.getString("encadrant.nom_encadrant"));
				stagiaire.setTheme(rs.getString("theme.theme"));
				stagiaire.setDateDebut(rs.getString("session.dat_debut"));
				stagiaire.setDateFin(rs.getString("session.dat_fin"));
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
				stagiaire.setId(rs.getInt("id_stagiaire"));
				stagiaire.setNom(rs.getString("nom"));
				stagiaire.setPrenom(rs.getString("prenom"));
//				stagiaire.setDateNaissance(rs.getDate("date_naissance"));
				stagiaire.setLieuNaissance(rs.getString("lieu_naissance"));
				stagiaire.setVille(rs.getString("ville"));
				stagiaire.setTelephone(rs.getString("telephone"));
				stagiaire.setEmail(rs.getString("email"));
				stagiaire.setCin(rs.getString("cin"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stagiaire;
	}

}
