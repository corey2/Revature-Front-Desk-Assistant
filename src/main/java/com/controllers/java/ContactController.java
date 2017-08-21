package com.controllers.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.java.AssociateDAO;
import com.pojos.java.AssociatePOJO;
import com.util.java.EmailGenerator;


//This controller is used when someone fills out the Contact Human Resources form.
@SuppressWarnings("serial")
public class ContactController extends HttpServlet {
	private AssociateDAO dao;
	private RequestDispatcher view;
	private static String SUBMIT_EMAIL = "SubmitEmailView.jsp";
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String username = (String) this.getServletContext().getAttribute("username");
		dao = new AssociateDAO();
		AssociatePOJO associate = dao.getAssociate(username);
		
		String recipient = "revaturefrontdeskassistant@gmail.com";
		String subject = request.getParameter("subject")+" (sent by "+associate.getFirstName()+" "+associate.getLastName()+")";
		String body = request.getParameter("message")+"\n\n"+"This associate can be emailed back at "+associate.getEmail();
		//System.out.println("subject = "+request.getParameter("subject"));
		//System.out.println("message = "+request.getParameter("message"));
		//System.out.println("email = "+request.getParameter("email"));
		
		request.setAttribute("emailType", "contactHREmail");
		EmailGenerator.run(recipient, subject, body);
		
		view = request.getRequestDispatcher(SUBMIT_EMAIL);
		view.forward(request, response);
		
		
	}
	
}
