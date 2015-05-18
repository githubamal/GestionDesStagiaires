package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.colaimo.util.DBUtil;
import com.colaimo.model.Encadrant;

public class EncadrantDao {

	private Connection connection;

	public EncadrantDao() {
		connection = DBUtil.getConnection();
	}

	/**
	 * Ajouter un encadrant
	 * 
	 * @param encadrant
	 */
	public void ajouterEncadrant(Encadrant encadrant) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into encadrant(nom_encadrant,prenom_encadrant,email,telephone,login,password) values (?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, encadrant.getNom());
			preparedStatement.setString(2, encadrant.getPrenom());
			preparedStatement.setString(3, encadrant.getEmail());
			preparedStatement.setString(4, encadrant.getTelephone());
			preparedStatement.setString(5, encadrant.getLogin());
			preparedStatement.setString(6, encadrant.getPassword());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * suppression encadrant
	 * 
	 * @param encadrantId
	 */
	public void deleteEncadrant(int encadrantId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from encadrant where id_encadrant=?");
			// Parameters start with 1
			preparedStatement.setInt(1, encadrantId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mis à jour encadrant
	 * 
	 * @param encadrant
	 */
	public void updateEncadrant(Encadrant encadrant) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update encadrant set nom_encadrant=?, prenom_encadrant=?, email=?, telephone=?, login=?, password=?"
							+ "where id_encadrant=?");
			// Parameters start with 1
			preparedStatement.setString(1, encadrant.getNom());
			preparedStatement.setString(2, encadrant.getPrenom());
			preparedStatement.setString(3, encadrant.getEmail());
			preparedStatement.setString(4, encadrant.getTelephone());
			preparedStatement.setString(5, encadrant.getLogin());
			preparedStatement.setString(6, encadrant.getPassword());
			preparedStatement.setInt(7, encadrant.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * recuperer tout les encadrants
	 * 
	 * @return
	 */
	public List<Encadrant> getAllEncadrant() {
		List<Encadrant> listEncadrant = new ArrayList<Encadrant>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from encadrant");
			while (rs.next()) {
				Encadrant encadrant = new Encadrant();
				encadrant.setId(rs.getInt("id_encadrant"));
				encadrant.setNom(rs.getString("nom_encadrant"));
				encadrant.setPrenom(rs.getString("prenom_encadrant"));
				encadrant.setEmail(rs.getString("email"));
				encadrant.setTelephone(rs.getString("telephone"));
				encadrant.setLogin(rs.getString("login"));
				encadrant.setPassword(rs.getString("password"));
				listEncadrant.add(encadrant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listEncadrant;
	}

	/**
	 * recuperer encadrant par Id
	 * 
	 * @param encadrantId
	 * @return
	 */
	public Encadrant getEncadrantById(int encadrantId) {
		Encadrant encadrant = new Encadrant();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from encadrant where id_encadrant=?");
			preparedStatement.setInt(1, encadrantId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				encadrant.setId(rs.getInt("id_encadrant"));
				encadrant.setNom(rs.getString("nom_encadrant"));
				encadrant.setPrenom(rs.getString("prenom_encadrant"));
				encadrant.setEmail(rs.getString("email"));
				encadrant.setTelephone(rs.getString("telephone"));
				encadrant.setLogin(rs.getString("login"));
				encadrant.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return encadrant;
	}

	/**
	 * recuperer encadrant par Id
	 * 
	 * @param encadrantId
	 * @return
	 */
	public Encadrant login(String login, String password) {
		Encadrant encadrant = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from encadrant where login=? and password=?");
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				encadrant = new Encadrant();
				encadrant.setId(rs.getInt("id_encadrant"));
				encadrant.setNom(rs.getString("nom_encadrant"));
				encadrant.setPrenom(rs.getString("prenom_encadrant"));
				encadrant.setEmail(rs.getString("email"));
				encadrant.setTelephone(rs.getString("telephone"));
				encadrant.setLogin(rs.getString("login"));
				encadrant.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return encadrant;
	}

	/**
	 * recuperer encadrant par Id
	 * 
	 * @param encadrantId
	 * @return
	 */
	public boolean isEncadrantExist(String login, String password) {
		boolean isExist = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from encadrant where login='"
							+ login + "' and password='" + password + "'");
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isExist;
	}
}
