package com.controllers.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.java.LoginDAO;
import com.pojos.java.LoginPOJO;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO dao;
	private LoginPOJO login;
	private RequestDispatcher view;
	
	private static String SEARCH_ASSOCIATE = "/Search.jsp";
	private static String HOME = "/Admin.jsp";
	private static String LOGIN = "/Login.jsp";
	
	public UserController() {
		super();
		dao = new LoginDAO();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		login = new LoginPOJO();
		login.setUsername(request.getParameter("associateUN"));
		
		//System.out.println("User to delete from login: "+request.getParameter("associateUN"));
		//System.out.println("User put into login pojo: "+login.getUsername());
		dao.deleteLoginRecord(login);
		
		view = request.getRequestDispatcher(HOME);
		view.forward(request, response);
	}
	
	
	
}
	