package com.colaimo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.colaimo.dao.ServiceDao;
import com.colaimo.model.Service;
import com.colaimo.util.ConstantesActions;

public class ServiceController {
	private static String AJOUT_MODIFIER = "/pages/service/service.jsp";
	private static String LISTE_SERVICE = "/pages/service/services.jsp";
	
	ServiceDao serviceDao = new ServiceDao();

	
	private void ajouterEtModifierService(HttpServletRequest request,
			HttpServletResponse response) {
		Service service = new Service();
		String id = request.getParameter("id");
		if (StringUtils.isNoneBlank(id)) {
			service.setId(Integer.parseInt(request.getParameter("id")));
		}
		service.setNom(request.getParameter("nom"));
		service.setChef(request.getParameter("chef"));
		// appel dao
		if (service.getId() == null) {
			serviceDao.ajouterService(service);
		} else {
			serviceDao.updateService(service);
		}
		request.setAttribute("services", serviceDao.getAllService());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_SERVICE);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	private void chercherService(HttpServletRequest request,
			HttpServletResponse response) {
		Service service = new Service();
		service.setNom(request.getParameter("nom"));
		service.setChef(request.getParameter("chef"));
		request.setAttribute("services", serviceDao.chercherService(service));
		RequestDispatcher view = request.getRequestDispatcher(LISTE_SERVICE);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}			
	}

	private void supprimerService(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("idsupp"));
		serviceDao.deleteService(id);
		request.setAttribute("services", serviceDao.getAllService());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_SERVICE);
		try 
		{
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}
	
	private void recupererService(HttpServletRequest request,
			HttpServletResponse response) {
		int servId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("service", serviceDao.getServiceById(servId));
		RequestDispatcher view = request.getRequestDispatcher(AJOUT_MODIFIER);
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void listerService(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute("services", serviceDao.getAllService());
		RequestDispatcher view = request.getRequestDispatcher(LISTE_SERVICE);
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
			ajouterEtModifierService(request,response);
		}
		else if (ConstantesActions.LISTER.equals(action)) {
			listerService(request,response);
		}
		else if (ConstantesActions.SUPPRIMER.equals(action)) {
			supprimerService(request,response);
		}
		else if (ConstantesActions.CHERCHER.equals(action)) {
			chercherService(request,response);
		}
		else if (ConstantesActions.RECUPERER.equals(action)) {
			recupererService(request,response);
		}
	}

}
