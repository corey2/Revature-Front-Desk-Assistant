package com.controllers.java;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.java.AssociateDAO;
import com.pojos.java.AssociatePOJO;
import com.pojos.java.Capitalizer;
import com.pojos.java.EmailGenerator;

@SuppressWarnings("serial")
public class AssociateController extends HttpServlet {
	private AssociateDAO dao;
	private AssociatePOJO associate;
	private RequestDispatcher view;
	private static String UPDATE_COMPLETE = "/UpdateComplete.jsp";
	private static String FORM = "/AssociateForm.jsp";

	public AssociateController() {
		super();
		dao = new AssociateDAO();
	}

	//This get method is what allows the associate form to be pre-filled when the associate links to it from their home page.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String username = (String) this.getServletContext().getAttribute("username");
		associate = dao.getAssociate(username);
		request.setAttribute("associate", associate);
		view = request.getRequestDispatcher(FORM);
		view.forward(request, response);
	}

	//This method prepares a POJO that is used by the DAO to update an associate in the database after that associate fills out the
	//associate form.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		associate = new AssociatePOJO();
		String username = (String) this.getServletContext().getAttribute("username");
		associate.setUsername(username);
		associate.setFirstName(Capitalizer.use(request.getParameter("firstName")));
		associate.setLastName(Capitalizer.use(request.getParameter("lastName")));
		associate.setSex(request.getParameter("sex"));
		associate.setEmail(request.getParameter("email"));
		associate.setPhoneNumber(Long.parseLong(request.getParameter("phoneNum")));
		associate.setAddress(request.getParameter("address"));
		associate.setCity(request.getParameter("city"));
		associate.setState(request.getParameter("state"));
		associate.setZip(request.getParameter("zip"));
		try {
			Date dob = new SimpleDateFormat("MM.dd.yyyy").parse(request.getParameter("date"));
			associate.setArrivalDate(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		associate.setMethodOfTrans(request.getParameter("methTrans"));
		associate.setCarDuringTraining(request.getParameter("hasCar"));
		
		dao.updateAssociate(associate);
		
		//String recipients = List of admin emails from the database
		String recipient = "revaturefrontdeskassistant@gmail.com";
		String subject = associate.getFirstName()+" "+associate.getLastName()+"'s information has been updated in the database";
		String body = "The associate filled in the associate form to add/edit their personal information:"
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
