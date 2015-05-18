package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.colaimo.model.Session;
import com.colaimo.util.DBUtil;

public class SessionDao {

	private Connection connection;

	public SessionDao() {
		connection = DBUtil.getConnection();
	}

	/**
	 * Ajouter une Session
	 * 
	 * @param session
	 */

	public void ajouterSession(Session session) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into session(dat_debut,dat_fin) values (?, ?)");
			preparedStatement.setDate(1, new java.sql.Date(session
					.getDatDebut().getTime()));
			preparedStatement.setDate(1, new java.sql.Date(session.getDatFin()
					.getTime()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Supprimer une session
	 * @param sessionId
	 */
	public void deleteSession(int sessionId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from session where id_session=?");
			// Parameters start with 1
			preparedStatement.setInt(1, sessionId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Mettre à jour une session
	 * @param session
	 */
	
	public void updateSession(Session session) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update session set dat_debut=?, dat_fin=?" +
							"where id_session=?");
			// Parameters start with 1
			preparedStatement.setDate(1, new java.sql.Date(session
					.getDatDebut().getTime()));
			preparedStatement.setDate(2, new java.sql.Date(session
					.getDatFin().getTime()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Recuperer tout les encadrants
	 * @return
	 */
	
	public List<Session> getAllSession() {
		List<Session> listSession= new ArrayList<Session>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from session");
			while (rs.next()) {
				Session session = new Session();
				session.setDatDebut(rs.getDate("dat_debut"));
				session.setDatFin(rs.getDate("dat_fin"));
				listSession.add(session);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listSession;
	}

	/**
	 * recuperer session par Id
	 * @param sessionId
	 * @return
	 */
	
	public Session getSessionById(int sessionId) {
		Session session = new Session();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from encadrant where id_encadrant=?");
			preparedStatement.setInt(1, sessionId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				session.setDatDebut(rs.getDate("dat_debut"));
				session.setDatFin(rs.getDate("dat_fin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return session;
	}
	
	
}