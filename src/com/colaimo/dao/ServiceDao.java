package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.colaimo.model.Service;
import com.colaimo.util.DBUtil;

public class ServiceDao {
	private Connection connection;

	public ServiceDao() {
		connection = DBUtil.getConnection();
	}

	/**
	 * Ajouter un service
	 * 
	 * @param service
	 */
	public void ajouterService(Service service) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into service(nom_srv,srv) values (?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, service.getNom());
			preparedStatement.setString(2, service.getChef());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * suppression service
	 * 
	 * @param serviceId
	 */
	public void deleteService(int serviceId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from service where id_srv=?");
			// Parameters start with 1
			preparedStatement.setInt(1, serviceId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mis à jour service
	 * 
	 * @param service
	 */
	public void updateService(Service service) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update encadrant set nom_srv=?, chef_srv=?"
							+ "where id_srv=?");
			// Parameters start with 1
			preparedStatement.setString(1, service.getNom());
			preparedStatement.setString(2, service.getChef());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * recuperer tout les services
	 * 
	 * @return
	 */
	public List<Service> getAllService() {
		List<Service> listService = new ArrayList<Service>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from service");
			while (rs.next()) {
				Service service = new Service();
				service.setId(rs.getInt("id_srv"));
				service.setNom(rs.getString("nom_srv"));
				service.setChef(rs.getString("chef_srv"));
				listService.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listService;
	}

	/**
	 * recuperer service par Id
	 * 
	 * @param serviceId
	 * @return
	 */
	public Service getServiceById(int serviceId) {
		Service service = new Service();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from service where id_srv=?");
			preparedStatement.setInt(1, serviceId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				service.setId(rs.getInt("id_srv"));
				service.setNom(rs.getString("nom_srv"));
				service.setChef(rs.getString("chef_srv"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return service;
	}

}