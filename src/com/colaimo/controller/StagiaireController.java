package com.colaimo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.dao.EncadrantDao;
import com.colaimo.dao.FormationDao;
import com.colaimo.dao.StagiaireDao;
import com.colaimo.dao.ThemeDao;
import com.colaimo.model.Stagiaire;
import com.colaimo.util.ConstantesActions;

public class StagiaireController {
	private static String AJOUT_MODIFIER = "/pages/stagiaire/stagiaire.jsp";
	private static String LISTE_STAGIAIRE = "/pages/stagiaire/stagiaires.jsp";

	StagiaireDao stagiaireDao = new StagiaireDao();

	private void ajouterEtModifierStagiaire(HttpServletRequest request,
			HttpServletResponse response) {

		Stagiaire stagiaire = new Stagiaire();
		String id = request.getParameter("id");
		if(StringUtils.isNoneBlank(id))
		{
			stagiaire.setId(Integer.parseInt(request.getParameter("id")));
		}
		stagiaire.setNom(request.getParameter("nom"));
		stagiaire.setPrenom(request.getParameter("prenom"));
		stagiaire.setDateNaissance(request.getParameter("datenaissance"));
		stagiaire.setLieuNaissance(request.getParameter("lieunaissance"));
		stagiaire.setVille(request.getParameter("ville"));
		stagiaire.setTelephone(request.getParameter("telephone"));
		stagiaire.setEmail(request.getParameter("email"));
		stagiaire.setCin(request.getParameter("cin"));
		stagiaire.setIdEncadrant(request.getParameter("idencadrant"));
		stagiaire.setIdtheme(request.getParameter("idtheme"));
		stagiaire.setIdFormation(request.getParameter("idformation"));
		stagiaire.setDateDebut(request.getParameter("datDebut"));
		stagiaire.setDateFin(request.getParameter("datFin"));
		// appel dao
		if(stagiaire.getId() == null)
		{
			stagiaireDao.ajouterStagiaire(stagiaire);
		}
		else
		{
			stagiaireDao.updateStagiaire(stagiaire); 
		}
		request.setAttribute("stagiaires", stagiaireDao.getAllStagiaire());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_STAGIAIRE);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void chercherStagiaire(HttpServletRequest request,
			HttpServletResponse response) {

		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setNom(request.getParameter("nom"));
		stagiaire.setPrenom(request.getParameter("prenom"));
		stagiaire.setDateNaissance(request.getParameter("datenaissance"));
		stagiaire.setLieuNaissance(request.getParameter("lieunaissance"));
		stagiaire.setVille(request.getParameter("ville"));
		stagiaire.setTelephone(request.getParameter("telephone"));
		stagiaire.setEmail(request.getParameter("email"));
		stagiaire.setCin(request.getParameter("cin"));
		
		request.setAttribute("stagiaires", stagiaireDao.chercherStagiaires(stagiaire));
		RequestDispatcher view = request.getRequestDispatcher(LISTE_STAGIAIRE);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void supprimerStagiaire(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("idsupp"));
		stagiaireDao.deleteStagiaire(id);
		request.setAttribute("stagiaires", stagiaireDao.getAllStagiaire());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_STAGIAIRE);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void recupererStagiaire(HttpServletRequest request,
			HttpServletResponse response) {
		ThemeDao themeDao = new ThemeDao();
		EncadrantDao encadrantDao = new EncadrantDao();
		FormationDao formationDao = new FormationDao();
		if (StringUtils.isNoneBlank(request.getParameter("id"))) {
		int stagiaireId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("stagiaire", stagiaireDao.getStagiaireById(stagiaireId));
		}
		RequestDispatcher view = request.getRequestDispatcher(AJOUT_MODIFIER);
		request.setAttribute("encadrants", encadrantDao.getAllEncadrant());
		request.setAttribute("themes", themeDao.getAllTheme());
		request.setAttribute("formations", formationDao.getAllFormation());
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void listerStagiaire(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("stagiaires", stagiaireDao.getAllStagiaire());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_STAGIAIRE);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actionDispatcher(HttpServletRequest request,
			HttpServletResponse response) {
		String action = request.getParameter("action");

		if (ConstantesActions.AJOUTER_MODIFIER.equals(action)) {
			ajouterEtModifierStagiaire(request, response);
		} 
		else if (ConstantesActions.SUPPRIMER.equals(action)) {
			supprimerStagiaire(request, response);
		} 
		else if (ConstantesActions.CHERCHER.equals(action)) {
			chercherStagiaire(request, response);
		}
		else if (ConstantesActions.LISTER.equals(action)) {
			listerStagiaire(request, response);
		}
		else if (ConstantesActions.RECUPERER.equals(action)) {
			recupererStagiaire(request, response);
		}
	}

}
