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

import com.Dao.java.AdminDAO;
import com.pojos.java.AdminPOJO;
import com.pojos.java.AssociatePOJO;
import com.pojos.java.Capitalizer;


@SuppressWarnings("serial")
public class AdminController extends HttpServlet {
	private AdminDAO dao;
	private AssociatePOJO associate;
	private AdminPOJO admin;
	private RequestDispatcher view;
	private static String HOME = "/Admin.jsp";
	private static String DASHBOARD = "/AdminDash.jsp";
	//private static String ADD_ASSOCIATE = "/Add.jsp";
	private static String UPDATE_ASSOCIATE = "/Update.jsp";
	private static String UPDATE_COMPLETE = "/UpdateComplete.jsp";
	//private static String DELETE_ASSOCIATE = "/Delete.jsp";
	private static String SEARCH_ASSOCIATE = "/Search.jsp";
	
	
    public AdminController() {
        super();
        dao = new AdminDAO();
    }
    
    //This method handles situations where associate-related information needs to be saved as the admin links from one page in
    //the web application to another.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String behavior = request.getParameter("behavior");
        
    	if (behavior.equalsIgnoreCase("listAssociates")) {  //Admin.jsp -> AdminDash.jsp
    		request.setAttribute("associates", dao.getAllAssociates());
    		view = request.getRequestDispatcher(DASHBOARD);
    	} else if (behavior.equalsIgnoreCase("update")){  //AdminDash.jsp or Search.jsp -> Update.jsp
            String associateUsername = request.getParameter("associateUN");
            associate = dao.getAssociate(associateUsername);
            request.setAttribute("associate", associate);
            view = request.getRequestDispatcher(UPDATE_ASSOCIATE);
        } else if (behavior.equalsIgnoreCase("delete")){  //AdminDash.jsp -> Search.jsp
        	String associateUsername = request.getParameter("associateUN");
            associate = dao.getAssociate(associateUsername);
            request.setAttribute("associate", associate);
            view = request.getRequestDispatcher(SEARCH_ASSOCIATE);
        } else {  //Error
            System.out.println("You should have passed a parameter to the admin controller but you didn't");
        	view = request.getRequestDispatcher(HOME);
        }
        view.forward(request, response);
    }
    
    //This method handles situations where an admin wants to an interact with the database. This is done by setting up POJOs
    //and passing them as parameters to DAO methods.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	associate = new AssociatePOJO();
    	admin = new AdminPOJO();
    	String crudMethod = request.getParameter("crudMethod");
    	
    	if (crudMethod.equals("create")) {   //From Create.jsp 
    		if (request.getParameter("userType").equals("associate")) {
	    		associate.setUsername(request.getParameter("newUN"));
	        	associate.setFirstName(Capitalizer.use(request.getParameter("firstName")));
	        	associate.setLastName(Capitalizer.use(request.getParameter("lastName")));
	        	associate.setEmail(request.getParameter("email"));
	    		dao.addAssociate(associate);
    		} else {  //request.getParameter("userType").equals("admin")
    			admin.setUsername(request.getParameter("newUN"));
	        	admin.setFirstName(Capitalizer.use(request.getParameter("firstName")));
	        	admin.setLastName(Capitalizer.use(request.getParameter("lastName")));
	        	admin.setEmail(request.getParameter("email"));
	    		dao.addAdmin(admin);
    		}
    		view = request.getRequestDispatcher("/sendLoginEmail");
    	}
    	
    	if (crudMethod.equals("read")) {    //From Search.jsp
    		String fn = Capitalizer.use(request.getParameter("firstName"));
    		String ln = Capitalizer.use(request.getParameter("lastName"));
    		String fntrim = fn.trim();
    		String lntrim = ln.trim();
    		associate = dao.getAssociateByFullName(fntrim, lntrim);
    		System.out.println(associate.getFirstName());
    		request.setAttribute("associate", associate);
    		view = request.getRequestDispatcher(SEARCH_ASSOCIATE);
    	}
    	
    	//Prepares a POJO to change/add associate records in the database 
    	if (crudMethod.equals("update")) {   //From Update.jsp
        	associate.setUsername(request.getParameter("associateUN"));
        	associate.setFirstName(Capitalizer.use(request.getParameter("firstName")));
        	associate.setLastName(Capitalizer.use(request.getParameter("lastName")));
        	associate.setSex(request.getParameter("sex"));
        	associate.setEmail(request.getParameter("email"));
        	associate.setAddress(request.getParameter("address"));
        	associate.setCity(request.getParameter("city"));
        	associate.setState(request.getParameter("state"));
        	associate.setZip(Integer.parseInt(request.getParameter("zip")));
        	associate.setPhoneNumber(Long.parseLong(request.getParameter("phoneNum")));
            associate.setMethodOfTrans(request.getParameter("methTrans"));
            associate.setCarDuringTraining(request.getParameter("hasCar"));
            
            try { 
            	Date date = new SimpleDateFormat("MM.dd.yyyy").parse(request.getParameter("date"));
            	associate.setArrivalDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            dao.updateAssociate(associate);
 
            view = request.getRequestDispatcher(UPDATE_COMPLETE);
    	}
        
        if (crudMethod.equals("delete")) {
        	//System.out.println("Username = "+request.getParameter("associateUN"));
        	dao.deleteAssociate(request.getParameter("associateUN"));  //From Search.jsp
        	view = request.getRequestDispatcher("/changeUserInfo");
        }
        view.forward(request, response);
    
    }
}