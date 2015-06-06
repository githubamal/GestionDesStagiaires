package com.colaimo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.dao.FormationDao;
import com.colaimo.model.Formation;
import com.colaimo.util.ConstantesActions;

public class FormationController {
	private static String AJOUT_MODIFIER = "/pages/formation/formation.jsp";
	private static String LISTE_FORMATION = "/pages/formation/formations.jsp";
	
	FormationDao formationDao = new FormationDao();
	
	private void ajouterEtModifierFormation(HttpServletRequest request,
			HttpServletResponse response) {
		
		Formation formation = new Formation();
		String id = request.getParameter("id");
		if (StringUtils.isNoneBlank(id)) {
			formation.setId(Integer.parseInt(request.getParameter("id")));
		}
		formation.setEtablissement(request.getParameter("etablissement"));
		formation.setDiplome(request.getParameter("diplome"));
		formation.setFiliere(request.getParameter("filiere"));		
		
		// appel dao
		if (formation.getId() == null) {
			formationDao.ajouterFormation(formation);
		} else {
			formationDao.updateFormation(formation);
		}
		request.setAttribute("formations", formationDao.getAllFormation());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_FORMATION);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	private void chercherFormation(HttpServletRequest request,
			HttpServletResponse response) {
		Formation formation = new Formation();
		formation.setEtablissement(request.getParameter("etablissement"));
		formation.setDiplome(request.getParameter("diplome"));
		formation.setFiliere(request.getParameter("filiere"));
		request.setAttribute("formations", formationDao.chercherFormation(formation));
		RequestDispatcher view = request.getRequestDispatcher(LISTE_FORMATION);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}

	private void supprimerFormation(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("idsupp"));
		formationDao.deleteFormation(id);
		request.setAttribute("formations", formationDao.getAllFormation());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_FORMATION);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}

	private void recupererFormation(HttpServletRequest request,
			HttpServletResponse response) {
		int formationId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("formation", formationDao.getFormationById(formationId));
		RequestDispatcher view = request.getRequestDispatcher(AJOUT_MODIFIER);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void listerFormation(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("formations", formationDao.getAllFormation());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_FORMATION);
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
			ajouterEtModifierFormation(request,response);
		}
		else if (ConstantesActions.SUPPRIMER.equals(action)) {
			supprimerFormation(request,response);
		}
		else if (ConstantesActions.CHERCHER.equals(action)) {
			chercherFormation(request,response);
		}
		else if (ConstantesActions.LISTER.equals(action)) {
			listerFormation(request,response);
		}
		else if (ConstantesActions.RECUPERER.equals(action)) {
			recupererFormation(request,response);
		}
	}


}
