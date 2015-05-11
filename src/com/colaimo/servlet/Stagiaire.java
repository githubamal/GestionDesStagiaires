package com.colaimo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Stagiaire extends HttpServlet{
	int var=0;
	public void init(){
		var=2;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<h1>" +var + "</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void destroy(){
		var=9;
		System.out.println(var);
	}

}
