package com.project.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.project.jdbc.LoginDb;
import com.project.model.Login;

@WebServlet("/LoginServlet")
public class LoginController extends HttpServlet{
	
	private LoginDb loginDb;
	
	@Resource(name="jdbc/academia")
	private DataSource datasource;
	
	private static final long serialVersionUID = -1083126838419352162L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			Login login = loginDb.getLogin();
			if(login.getUsername().equals(username) && login.getPassword().equals(password)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}


}
