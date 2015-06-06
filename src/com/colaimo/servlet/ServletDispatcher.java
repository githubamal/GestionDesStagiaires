package com.colaimo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.colaimo.controller.EncadrantController;
import com.colaimo.controller.FormationController;
import com.colaimo.controller.ServiceController;
import com.colaimo.controller.StageController;
import com.colaimo.controller.StagiaireController;
import com.colaimo.controller.ThemeController;
import com.colaimo.util.ConstantesControllers;

public class ServletDispatcher extends HttpServlet {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	EncadrantController encadrantController;
	FormationController formationController;
	ServiceController serviceController;
	StageController stageController;
	StagiaireController stagiaireController;
	ThemeController themeController;
	
	/**
	 * Initialisation
	 */
	public void init() throws ServletException {
		encadrantController = new EncadrantController();
		formationController = new FormationController();
		serviceController = new ServiceController();
		stageController = new StageController();
		stagiaireController = new StagiaireController();
		themeController = new ThemeController();
	}

	
	/**
	 * Methode doGet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String controller = request.getParameter("controller");
		
		if(ConstantesControllers.ENCADRANT_CONTROLLER.equals(controller))
		{
			encadrantController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.FORMATION_CONTROLLER.equals(controller))
		{
			formationController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.SERVICE_CONTROLLER.equals(controller))
		{
			serviceController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.STAGE_CONTROLLER.equals(controller))
		{
			stageController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.STAGIAIRE_CONTROLLER.equals(controller))
		{
			stagiaireController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.THEME_CONTROLLER.equals(controller))
		{
			themeController.actionDispatcher(request, response);
		}
		

	}

	/** 
	 * Methode doPost
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String controller = request.getParameter("controller");
		
		if(ConstantesControllers.ENCADRANT_CONTROLLER.equals(controller))
		{
			encadrantController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.FORMATION_CONTROLLER.equals(controller))
		{
			formationController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.SERVICE_CONTROLLER.equals(controller))
		{
			serviceController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.STAGE_CONTROLLER.equals(controller))
		{
			stageController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.STAGIAIRE_CONTROLLER.equals(controller))
		{
			stagiaireController.actionDispatcher(request, response);
		}
		else if(ConstantesControllers.THEME_CONTROLLER.equals(controller))
		{
			themeController.actionDispatcher(request, response);
		}

	}

	public void destroy() {
	}
}
