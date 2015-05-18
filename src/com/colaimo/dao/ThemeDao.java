package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.colaimo.model.Theme;
import com.colaimo.util.DBUtil;

public class ThemeDao {
	private Connection connection;

	public ThemeDao() {
		connection = DBUtil.getConnection();
	}

	/**
	 * Ajouter un theme
	 * 
	 * @param theme
	 */
	public void ajouterTheme(Theme theme) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into theme(theme) values (?)");
			// Parameters start with 1
			preparedStatement.setString(1, theme.getTheme());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * suppression theme
	 * 
	 * @param themeId
	 */
	public void deleteTheme(int themeId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from theme where id_theme=?");
			// Parameters start with 1
			preparedStatement.setInt(1, themeId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mis à jour theme
	 * 
	 * @param theme
	 */
	public void updateTheme(Theme theme) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update theme set theme=?"
							+ "where id_theme=?");
			// Parameters start with 1
			preparedStatement.setString(1, theme.getTheme());
			preparedStatement.setInt(2, theme.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * recuperer tout les themes
	 * 
	 * @return
	 */
	public List<Theme> getAllTheme() {
		List<Theme> listTheme = new ArrayList<Theme>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from theme");
			while (rs.next()) {
				Theme theme = new Theme();
				theme.setId(rs.getInt("id_theme"));
				theme.setTheme(rs.getString("theme"));
				listTheme.add(theme);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listTheme;
	}

	/**
	 * recuperer theme par Id
	 * 
	 * @param themeId
	 * @return
	 */
	public Theme getThemeById(int themeId) {
		Theme theme = new Theme();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from theme where id_theme=?");
			preparedStatement.setInt(1, themeId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				theme.setId(rs.getInt("id_theme"));
				theme.setTheme(rs.getString("theme"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return theme;
	}

}
