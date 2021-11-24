package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginController extends HttpServlet{
	
	private static final long serialVersionUID = -1083126838419352162L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String senha = request.getParameter("senha");
		if(senha.length() > 5) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/form-response.jsp");
			dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}


}
