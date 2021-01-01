package com.amit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

	/**
	 * Default serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String userName= req.getParameter("userName");
		String password= req.getParameter("password");
		System.out.println("User name: "+ userName);
		System.out.println("Password: "+ password);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/home.jsp");
        requestDispatcher.forward(req, res);
	}

}
