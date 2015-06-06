package com.colaimo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.colaimo.dao.AdminDao;
import com.colaimo.dao.EncadrantDao;
import com.colaimo.model.Admin;
import com.colaimo.model.Encadrant;
import com.colaimo.util.ConstantesPages;

public class ServletLogin extends HttpServlet {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initialisation
	 */
	public void init() throws ServletException {
	}

	/** 
	 * Methode doGet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isLougout = request.getParameter("lougout");
		String forward="";

		/* Création ou récupération de la session */
		HttpSession session = request.getSession();
		if("1".equals(isLougout)){

	        session.invalidate();  
	        forward = ConstantesPages.LOGIN_PAGE;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
//		request.setAttribute("encad", encadrant);
        view.forward(request, response);
	}
	/** 
	 * Methode doPost
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward="";
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		String isAdmin = request.getParameter("admin");
		String isLougout = request.getParameter("lougout");

		/* Création ou récupération de la session */
		HttpSession session = request.getSession();
		if("1".equals(isLougout)){

	        session.invalidate();  
	        forward = ConstantesPages.LOGIN_PAGE;
		}
		else{
		
		if("1".equals(isAdmin))
		{
			AdminDao adminDao = new AdminDao();
			Admin admin = adminDao.login(login, password);
			if(admin==null){
				forward = ConstantesPages.LOGIN_PAGE;
				session.setAttribute( "connecte", "error" );
			}
			else{
				forward = ConstantesPages.HOME_ADMIN;
				session.setAttribute( "admin", "admin" );
				session.setAttribute( "profil", admin );
			}
		}
		else
		{
			EncadrantDao encadrantDao = new EncadrantDao();
			Encadrant encadrant = encadrantDao.login(login, password);
			if(encadrant==null){
				forward = ConstantesPages.LOGIN_PAGE;
			}
			else{
				forward = ConstantesPages.HOME_ENCADRANT;

				session.setAttribute( "connecte", "success" );
				session.setAttribute( "admin", null );
				session.setAttribute( "profil", encadrant );
			}
		}
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
//		request.setAttribute("encad", encadrant);
        view.forward(request, response);
	}

	public void destroy() {
	}
}
