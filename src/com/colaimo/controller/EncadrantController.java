package com.colaimo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.dao.EncadrantDao;
import com.colaimo.model.Encadrant;
import com.colaimo.util.ConstantesActions;

public class EncadrantController {
	private static String AJOUT_MODIFIER = "/pages/encadrant/encadrant.jsp";
	private static String LISTE_ENCADRANT = "/pages/encadrant/encadrants.jsp";
	
	EncadrantDao encadrantDao = new EncadrantDao();

	private void ajouterEtModifierEncadrant(HttpServletRequest request,
			HttpServletResponse response) {
		Encadrant encadrant = new Encadrant();
		String id = request.getParameter("id");
		if(StringUtils.isNoneBlank(id))
		{
			encadrant.setId(Integer.parseInt(request.getParameter("id")));
		}
		encadrant.setNomE(request.getParameter("nom"));
		encadrant.setPrenomE(request.getParameter("prenom"));
		encadrant.setEmail(request.getParameter("email"));
		encadrant.setTelephone(request.getParameter("telephone"));
		encadrant.setLogin(request.getParameter("login"));
		encadrant.setPassword(request.getParameter("password"));
		// appel dao
		if(encadrant.getId() == null)
		{
		encadrantDao.ajouterEncadrant(encadrant);
		}
		else
		{
			encadrantDao.updateEncadrant(encadrant); 
		}
		request.setAttribute("encadrants", encadrantDao.getAllEncadrant());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_ENCADRANT);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	private void chercherEncadrant(HttpServletRequest request,
			HttpServletResponse response) {
		Encadrant encadrant = new Encadrant();
		encadrant.setNomE(request.getParameter("nom"));
		encadrant.setPrenomE(request.getParameter("prenom"));
		encadrant.setEmail(request.getParameter("email"));
		encadrant.setTelephone(request.getParameter("telephone"));
		encadrant.setLogin(request.getParameter("login"));
		encadrant.setPassword(request.getParameter("password"));
		
		request.setAttribute("encadrants", encadrantDao.chercherEncadrants(encadrant));
		RequestDispatcher view = request.getRequestDispatcher(LISTE_ENCADRANT);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}

	private void supprimerEncadrant(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("idsupp"));
		encadrantDao.deleteEncadrant(id);
		request.setAttribute("stagiaires", encadrantDao.getAllEncadrant());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_ENCADRANT);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
		
	

	private void recupererEncadrant(HttpServletRequest request,
			HttpServletResponse response) {
		int encadrantId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("encadrant", encadrantDao.getEncadrantById(encadrantId));
		RequestDispatcher view = request.getRequestDispatcher(AJOUT_MODIFIER);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void listerEncadrant(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("encadrants", encadrantDao.getAllEncadrant());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_ENCADRANT);
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
			ajouterEtModifierEncadrant(request,response);
		}
		else if (ConstantesActions.CHERCHER.equals(action)) {
			chercherEncadrant(request,response);
		}
		else if (ConstantesActions.SUPPRIMER.equals(action)) {
			supprimerEncadrant(request,response);
		}
		else if (ConstantesActions.LISTER.equals(action)) {
			listerEncadrant(request,response);
		}
		else if (ConstantesActions.RECUPERER.equals(action)) {
			recupererEncadrant(request, response);
		}
	}

}
