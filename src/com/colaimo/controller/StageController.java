package com.colaimo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.dao.StageDao;
import com.colaimo.dao.ThemeDao;
import com.colaimo.model.Stage;
import com.colaimo.util.ConstantesActions;

public class StageController {
	private static String AJOUT_MODIFIER = "/pages/stage/stage.jsp";
	private static String LISTE_STAGE = "/pages/stage/stages.jsp";

	StageDao stageDao = new StageDao();

	private void ajouterEtModifierStage(HttpServletRequest request,
			HttpServletResponse response) {

		Stage stage = new Stage();
		String id = request.getParameter("id");
		if (StringUtils.isNoneBlank(id)) {
			stage.setId(Integer.parseInt(request.getParameter("id")));
		}
		stage.setIntituleStage(request.getParameter("intitulestage"));

		// appel dao

		if (stage.getId() == null) {
			stageDao.ajouterStage(stage);
		} else {
			stageDao.updateStage(stage);
		}
		request.setAttribute("stages", stageDao.getAllStage());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_STAGE);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void chercherStage(HttpServletRequest request,
			HttpServletResponse response) {
		Stage stage = new Stage();
		stage.setIntituleStage(request.getParameter("intitulestage"));
		request.setAttribute("stages", stageDao.chercherStage(stage));
		RequestDispatcher view = request.getRequestDispatcher(LISTE_STAGE);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void supprimerStage(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("idsupp"));
		stageDao.deleteStage(id);
		request.setAttribute("stages", stageDao.getAllStage());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_STAGE);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void recupererStage(HttpServletRequest request,
			HttpServletResponse response) {
		ThemeDao themeDao = new ThemeDao();

		if (StringUtils.isNoneBlank(request.getParameter("id"))) {
			int stageId = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("stage", stageDao.getStageById(stageId));
		}
		RequestDispatcher view = request.getRequestDispatcher(AJOUT_MODIFIER);
		request.setAttribute("themes", themeDao.getAllTheme());
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void listerStage(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("stages", stageDao.getAllStage());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_STAGE);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void actionDispatcher(HttpServletRequest request,
			HttpServletResponse response) {
		String action = request.getParameter("action");

		if (ConstantesActions.AJOUTER_MODIFIER.equals(action)) {
			ajouterEtModifierStage(request, response);
		} 
		else if (ConstantesActions.SUPPRIMER.equals(action)) {
			supprimerStage(request, response);
		}
		else if (ConstantesActions.CHERCHER.equals(action)) {
			chercherStage(request, response);
		}
		else if (ConstantesActions.LISTER.equals(action)) {
			listerStage(request, response);
		} 
		else if (ConstantesActions.RECUPERER.equals(action)) {
			recupererStage(request, response);
		}
	}
}
