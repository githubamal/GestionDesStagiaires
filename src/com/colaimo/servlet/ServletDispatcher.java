package com.colaimo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.colaimo.model.Encadrant;
import com.colaimo.util.DBUtil;

public class ServletDispatcher extends HttpServlet {

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
		//String nomController = request.getParameter("controller");

	}

	/** 
	 * Methode doPost
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String nomController = request.getParameter("controller");

	}

	public void destroy() {
	}
}
