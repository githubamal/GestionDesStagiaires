package com.colaimo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.dao.ThemeDao;
import com.colaimo.model.Theme;
import com.colaimo.util.ConstantesActions;

public class ThemeController {
	private static String AJOUT_MODIFIER = "/pages/stage/theme.jsp";
	private static String LISTE_THEME = "/pages/stage/themes.jsp";

	ThemeDao themeDao = new ThemeDao();

	private void ajouterEtModifierTheme(HttpServletRequest request,
			HttpServletResponse response) {

		Theme theme = new Theme();
		String id = request.getParameter("id");
		if (StringUtils.isNoneBlank(id)) {
			theme.setId(Integer.parseInt(request.getParameter("id")));
		}
		theme.setTheme(request.getParameter("theme"));
		
		// appel dao

		if (theme.getId() == null) {
			themeDao.ajouterTheme(theme);
		} else {
			themeDao.updateTheme(theme);
		}
		request.setAttribute("themes", themeDao.getAllTheme());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_THEME);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void chercherTheme(HttpServletRequest request,
			HttpServletResponse response) {
		Theme theme = new Theme();
		theme.setTheme(request.getParameter("theme"));
		request.setAttribute("themes", themeDao.chercherTheme(theme));
		RequestDispatcher view = request.getRequestDispatcher(LISTE_THEME);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void supprimerTheme(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("idsupp"));
		themeDao.deleteTheme(id);
		request.setAttribute("themes", themeDao.getAllTheme());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_THEME);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void recupererTheme(HttpServletRequest request,
			HttpServletResponse response) {
		int themeId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("theme", themeDao.getThemeById(themeId));
		RequestDispatcher view = request.getRequestDispatcher(AJOUT_MODIFIER);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void listerTheme(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("themes", themeDao.getAllTheme());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_THEME);
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
			ajouterEtModifierTheme(request, response);
		}
		else if (ConstantesActions.SUPPRIMER.equals(action)) {
			supprimerTheme(request, response);
		} 
		else if (ConstantesActions.CHERCHER.equals(action)) {
			chercherTheme(request, response);
		}
		else if (ConstantesActions.LISTER.equals(action)) {
			listerTheme(request, response);
		} 
		else if (ConstantesActions.RECUPERER.equals(action)) {
			recupererTheme(request, response);
		}
	}

}
