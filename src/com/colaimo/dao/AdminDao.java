package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.colaimo.model.Admin;
import com.colaimo.util.DBUtil;

public class AdminDao {

	private Connection connection;

	public AdminDao() {
		connection = DBUtil.getConnection();
	}

	/**
	 * Ajouter un Admin
	 * 
	 * @param service
	 */
	public void ajouterAdmin(Admin admin) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into admin(login,password) values (?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, admin.getLogin());
			preparedStatement.setString(2, admin.getPassword());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * suppression admin
	 * 
	 * @param adminId
	 */
	public void deleteadmin(int adminId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from admin where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, adminId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mis à jour admin
	 * 
	 * @param admin
	 */
	public void updateAdmin(Admin admin) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update admin set login=?, password=?"
							+ "where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, admin.getLogin());
			preparedStatement.setString(2, admin.getPassword());
			preparedStatement.setInt(3, admin.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * recuperer tout les admins
	 * 
	 * @return
	 */
	public List<Admin> getAllAdmin() {
		List<Admin> listAdmin = new ArrayList<Admin>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from admin");
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setLogin(rs.getString("login"));
				admin.setPassword(rs.getString("password"));
				listAdmin.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listAdmin;
	}

	/**
	 * recuperer service par Id
	 * 
	 * @param serviceId
	 * @return
	 */
	public Admin login(String login, String password) {
		Admin admin = null;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from admin where login=? and password=?");
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				admin= new Admin();
				admin.setId(rs.getInt("id"));
				admin.setLogin(rs.getString("login"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}

}
