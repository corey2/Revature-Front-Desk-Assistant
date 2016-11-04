package com.controllers.java;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.java.AssociateDAO;
import com.pojos.java.AssociatePOJO;
import com.pojos.java.Capitalizer;

@SuppressWarnings("serial")
public class AssociateController extends HttpServlet {
	private AssociateDAO dao;
	private AssociatePOJO associate;
	private RequestDispatcher view;
	//private static String UPDATE_COMPLETE = "/UpdateComplete.jsp";
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		associate = new AssociatePOJO();
		associate.setUsername((String) this.getServletContext().getAttribute("username"));
		associate.setFirstName(Capitalizer.use(request.getParameter("firstName")));
		associate.setLastName(Capitalizer.use(request.getParameter("lastName")));
		associate.setEmail(request.getParameter("email"));
		associate.setSex(request.getParameter("sex"));
		associate.setAddress(request.getParameter("address"));
		associate.setCity(request.getParameter("city"));
		associate.setState(request.getParameter("state"));
		associate.setZip(Integer.parseInt(request.getParameter("zip")));
		associate.setPhoneNumber(Long.parseLong(request.getParameter("phoneNum")));

		try {
			Date dob = new SimpleDateFormat("MM.dd.yyyy").parse(request.getParameter("date"));
			associate.setArrivalDate(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		associate.setMethodOfTrans(request.getParameter("methTrans"));
		
		final String temp = request.getParameter("hasCar");
		if(temp.equals("Yes")){
			associate.setCarDuringTraining(1);
		}
		else if(temp.equals("No")){
			associate.setCarDuringTraining(0);
		}
		dao.updateAssociate(associate);
		
		request.setAttribute("associate", associate);
		view = request.getRequestDispatcher("/sendConfirmationEmail");
        view.forward(request, response);
	}
}
