package com.controllers.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.java.LoginDAO;
import com.pojos.java.LoginPOJO;
import com.pojos.java.PasswordHelper;

@SuppressWarnings("serial")
public class LoginController extends HttpServlet{
	private LoginDAO dao;
	private LoginPOJO user;
	private RequestDispatcher view;
	private static String ASSOCIATE = "Associate.jsp";
	private static String ADMIN = "Admin.jsp";
	private static String LOGIN = "Login.jsp";
	
    public LoginController() {
        super();
        dao = new LoginDAO();
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	user = new LoginPOJO();
    	user.setUsername(request.getParameter("username"));
    	dao.completeUserInfo(user);
        
    	//String password = request.getParameter("password");
    	//System.out.println("Parameter Password = "+password);
    	//System.out.println("Hashed version of parameter password = "+PasswordHelper.hashpw(password));
    	//System.out.println("Database Password = "+user.getPassword());
    	//System.out.println("Result of password check = "+PasswordHelper.checkpw(password, user.getPassword()));
    	
    	if (PasswordHelper.checkpw(request.getParameter("password"), user.getPassword())) {    
        	if (user.getUserRole() == 1){
        		this.getServletContext().setAttribute("username", user.getUsername());  
                this.getServletContext().setAttribute("userRole", user.getUserRole());
        		view = request.getRequestDispatcher(ASSOCIATE);
        	} else if (user.getUserRole() == 2){
        		this.getServletContext().setAttribute("username", user.getUsername());  
                this.getServletContext().setAttribute("userRole", user.getUserRole());
        		view = request.getRequestDispatcher(ADMIN);
        	} else {
        		System.out.println("There must be some problem with the database because I don't know what kind of user you are.");  
        		view = request.getRequestDispatcher(LOGIN);
        	}
        } else {    
        	request.setAttribute("loginFail", true);
        	view = request.getRequestDispatcher(LOGIN);
        }
        
        	
        
        view.forward(request, response);
    }    
}
