package com.colaimo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.colaimo.dao.EncadrantDao;
import com.colaimo.model.Encadrant;

public class ServletLogin extends HttpServlet {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;
    private static String LOGIN_PAGE = "/login.jsp";
    private static String ESPACE_ENCADRANT = "/pages/index.jsp";

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
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		

	}

	/** 
	 * Methode doPost
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward="";
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		EncadrantDao encadrantDao = new EncadrantDao();
		Encadrant encadrant = encadrantDao.login(login, password);
		if(encadrant==null){
			forward = LOGIN_PAGE;
		}
		else{
			forward = ESPACE_ENCADRANT;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		request.setAttribute("encad", encadrant);
        view.forward(request, response);
	}

	public void destroy() {
	}
}
