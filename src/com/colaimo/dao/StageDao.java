package com.colaimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.model.Stage;
import com.colaimo.util.DBUtil;

public class StageDao {

	private Connection connection;

	public StageDao() {
		connection = DBUtil.getConnection();
	}

	/**
	 * Ajouter un stage
	 * 
	 * @param stage
	 */
	public void ajouterStage(Stage stage) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into stage(intitule_stage) values (?)");
			// Parameters start with 1
			preparedStatement.setString(1, stage.getIntituleStage());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * suppression stage
	 * 
	 * @param stageId
	 */
	public void deleteStage(int stageId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from stage where id_stage=?");
			// Parameters start with 1
			preparedStatement.setInt(1, stageId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mis à jour stage
	 * 
	 * @param stage
	 */
	public void updateStage(Stage stage) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update stage set intitule_stage=?"
							+ "where id_stage=?");
			// Parameters start with 1
			preparedStatement.setString(1, stage.getIntituleStage());
			preparedStatement.setInt(2, stage.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * recuperer tout les Stages
	 * 
	 * @return
	 */
	public List<Stage> getAllStage() {
		List<Stage> listStage = new ArrayList<Stage>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from stage");
			while (rs.next()) {
				Stage stage = new Stage();
				stage.setId(rs.getInt("id_stage"));
				stage.setIntituleStage(rs.getString("intitule_stage"));
				listStage.add(stage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listStage;
	}

	/**
	 * recuperer tout les stages
	 * @return
	 */
	public List<Stage> chercherStage(Stage pStage) {
		List<Stage> listStage = new ArrayList<Stage>();
		try {

			String requete = "select * from stage WHERE 1=1 ";
			if (StringUtils.isNotBlank(pStage.getIntituleStage())) {
				requete += " AND intitule_stage= '" + pStage.getIntituleStage() + "' ";
			}
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(requete);
			while (rs.next()) {
				Stage stage = new Stage();
				stage.setId(rs.getInt("id_stage"));
				stage.setIntituleStage(rs.getString("intitule_stage"));
				listStage.add(stage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listStage;
	}
	
	/**
	 * recuperer stage par Id
	 * 
	 * @param stageId
	 * @return
	 */
	public Stage getStageById(int stageId) {
		Stage stage = new Stage();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from stage where id_stage=?");
			preparedStatement.setInt(1, stageId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				stage.setId(rs.getInt("id_stage"));
				stage.setIntituleStage(rs.getString("intitule_stage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stage;
	}


	

}