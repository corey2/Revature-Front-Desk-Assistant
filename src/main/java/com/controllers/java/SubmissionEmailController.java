package com.controllers.java;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojos.java.AssociatePOJO;
import com.pojos.java.EmailGenerator;

public class SubmissionEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private AssociateDAO dao;
	private AssociatePOJO associate;
	private RequestDispatcher view;
	private static String UPDATE_COMPLETE = "/UpdateComplete.jsp";
	
	//This controller is used to send an email to an admin to confirm that an associate was added to the database.
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		associate = (AssociatePOJO) request.getAttribute("associate");
		
		//String recipients = List of admin emails from the database
		String recipient = "revaturefrontdeskassistant@gmail.com";
		String subject = associate.getFirstName()+" "+associate.getLastName()+"'s information has been submitted to the database";
		String body = "New associate information has just been entered into the database:"
					//+"\n"+"Gender = "+associate.getSex()
					//+"\n"+"Address = "+associate.getAddress()
					//+"\n"+"City = "+associate.getCity()
					//+"\n"+"State = "+associate.getState()
					//+"\n"+"Zip Code = "+associate.getZip()
					//+"\n"+"Arrival Date = "+associate.getArrivalDate()
					//+"\n"+"Transportation Method = "+associate.getMethodOfTrans()
					//+"\n"+"Has Car? = "+associate.getCarDuringTraining()
					//+"\n"+"E-mail = "+associate.getEmail()
					//+"\n"+"Phone Number = "+associate.getPhoneNumber()		
		;		
		EmailGenerator.run(recipient, subject, body);
		view = request.getRequestDispatcher(UPDATE_COMPLETE);
		view.forward(request, response);		
	}
}	
