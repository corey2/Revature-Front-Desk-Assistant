package com.controllers.java;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.java.AdminDAO;
import com.Dao.java.LoginDAO;
import com.pojos.java.AdminPOJO;
import com.pojos.java.AssociatePOJO;
import com.pojos.java.EmailGenerator;
import com.pojos.java.LoginPOJO;
import com.pojos.java.PasswordHelper;


public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssociatePOJO associate;
	private AdminDAO adao;
	private AdminPOJO admin;
	private LoginDAO ldao;
	private LoginPOJO login;
	private RequestDispatcher view;
	private static String SUBMIT_EMAIL = "SubmitEmailView.jsp";
	private static String LOGIN = "Login.jsp";
	
	public PasswordController() {
		super();
		adao = new AdminDAO();
		ldao = new LoginDAO();
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String username = null;
		int role = 0;
		String recipient = request.getParameter("email");
		String passwordType = request.getParameter("passwordType");
		String subject = null;
		String body = null;
		
		if (passwordType.equals("temp")) {  
			String password = PasswordHelper.generatepw();
			String hashword = PasswordHelper.hashpw(password);
			if (this.getServletContext().getAttribute("userRole") != null) {  //This runs right after an admin adds a user to the database.
				int currentRole = (int) this.getServletContext().getAttribute("userRole");
				String userType = request.getParameter("userType");
				if (currentRole == 2) {
					username = request.getParameter("newUN");
					if (userType.equals("associate")) {
						role = 1;
					} else {
						role = 2;
					}
					login = new LoginPOJO(username, hashword, role);
					ldao.storePassword(login);
				} else {
					System.out.println("Something went wrong. You should not have access to this feature.");
				}
				subject = "Temporary login information for Revature Front Desk Assistant";
				if (userType.equals("associate")) {
					body = "Use the username and password listed below to log in to the Revature platform where "
								+ "you will be able to submit important information to Human Resources and Housing "
								+ "Departments regarding your arrival and stay in Reston. It is recommended you change  "
								+ "your password after you log in."
								+ "\n\n"
								+ "Username: "+username
								+ "\n"
								+ "Password: "+password
					;
				} else {
					body = "Use the username and password listed below to log in to the Revature platform where "
							+ "you to will be able to manage important information about associates who will soon be starting "
							+ "their training at Revature. It is recommended you change your password after you log in."
							+ "\n\n"
							+ "Username: "+username
							+ "\n"
							+ "Password: "+password
					;
				}
				request.setAttribute("emailType", "newPasswordEmail");
				EmailGenerator.run(recipient, subject, body);
			} else {	//This runs when someone forgot their password.
				adao = new AdminDAO();
				associate = adao.getAssociateByEmail(recipient);
				admin = adao.getAdmin("email", recipient);  
				//We might run into problems here if two people have the same email address as each other, but thats not very likely.
				if (admin != null || associate != null) {    
					if (associate != null) {
						username = associate.getUsername();
						role = 1;
					}
					if (admin != null) {
						username = admin.getUsername();
						role = 2;
					}	
					login = new LoginPOJO(username, hashword, role);
					ldao.updatePassword(login);
					subject = "Request for new password for Revature Front Desk Assistant";
					body = "Use the username and password listed below to regain access to your account. "
							+ "Russell said that you should change your password after you log in."
							+ "\n\n"
							+ "Username: "+username
							+ "\n"
							+ "Password: "+password
					;
					request.setAttribute("emailType", "forgotPasswordEmail");
					EmailGenerator.run(recipient, subject, body);
				} else {
					request.setAttribute("emailType", "addressNotFoundEmail");
				}
			}
			view = request.getRequestDispatcher(SUBMIT_EMAIL);
			
		} else if (passwordType.equals("perm")) {   //This runs when a user requests to change their password.
			username = (String) this.getServletContext().getAttribute("username");
			String password = request.getParameter("newPassword");
			String hashword = PasswordHelper.hashpw(password);
			//System.out.println("The unhashed password is "+password);
			//System.out.println("The hashed password is "+hashword);
			
			login = new LoginPOJO();
			login.setUsername(username);
			login.setPassword(hashword);
			ldao.updatePassword(login);
						
			view = request.getRequestDispatcher(LOGIN);
		}	
		view.forward(request, response);
	}
}
