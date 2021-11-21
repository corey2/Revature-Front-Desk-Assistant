package com.Dao.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojos.java.AssociatePOJO;
import com.util.java.Util;

public class AssociateDAO {
	protected Connection connection = null;

	public AssociateDAO() {
		connection = Util.getConnection();
	}
	
	//Prepared statement parameters start with 1.
	public void updateAssociate(AssociatePOJO associate){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update associate set firstname=?, lastname=?, sex=?, email=?, phoneNumber=?, address=?, " +
                            		  "city=?, state=?, zip=?, arrivalDate=?, methodOfTrans=?, carDuringTraining=? where username=?");
                    
            preparedStatement.setString(1, associate.getFirstName());
            preparedStatement.setString(2, associate.getLastName());
            preparedStatement.setString(3, associate.getSex());
            preparedStatement.setString(4, associate.getEmail());
            preparedStatement.setLong(5, associate.getPhoneNumber());
            preparedStatement.setString(6, associate.getAddress());
            preparedStatement.setString(7, associate.getCity());
            preparedStatement.setString(8, associate.getState());
            preparedStatement.setString(9, associate.getZip());
            
            java.util.Date utilDate = associate.getArrivalDate();
            
            if(utilDate != null){
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());     
                preparedStatement.setDate(10, sqlDate);
            }
            else{
            	preparedStatement.setDate(10, null);
            }
            
            preparedStatement.setString(11, associate.getMethodOfTrans());
            preparedStatement.setString(12, associate.getCarDuringTraining());
            preparedStatement.setString(13, associate.getUsername());         
            preparedStatement.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public AssociatePOJO getAssociate(String username) {
    	PreparedStatement preparedStatement = null;
    	AssociatePOJO associate = null;
        try {
			preparedStatement = connection.
				prepareStatement("select * from associate where username=?");
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	associate = buildAssociate(rs);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return associate;
        
    }
	
	public AssociatePOJO getAssociateByFullName(String firstName, String lastName) {
		PreparedStatement preparedStatement = null;
	    AssociatePOJO associate = null;
        try {
		   preparedStatement = connection.
			   prepareStatement("select * from associate where firstname=? and lastname=?");
	       preparedStatement.setString(1, firstName);
	       preparedStatement.setString(2, lastName);
	       ResultSet rs = preparedStatement.executeQuery();
	       while (rs.next()) {
	    	   associate = buildAssociate(rs);  
	       }
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
           return associate;
    }
	
	public AssociatePOJO getAssociateByEmail(String email) {
		PreparedStatement preparedStatement = null;
	    AssociatePOJO associate = null;
        try {
		   preparedStatement = connection.
			   prepareStatement("select * from associate where email=?");
	       preparedStatement.setString(1, email);
	       ResultSet rs = preparedStatement.executeQuery();
	       while (rs.next()) {
	    	   associate = buildAssociate(rs);  
	       }
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
           return associate;
    }
	
	//used in dao methods that use select statements to set up an AssociatePOJO based on the results of the query
    public AssociatePOJO buildAssociate(ResultSet rs) throws SQLException {
    	AssociatePOJO associate = new AssociatePOJO();
		associate.setUsername(rs.getString("username"));
		associate.setFirstName(rs.getString("firstname"));
		associate.setLastName(rs.getString("lastname"));
		associate.setSex(rs.getString("sex"));
		associate.setEmail(rs.getString("email"));
	    associate.setPhoneNumber(rs.getLong("phoneNumber"));
		associate.setAddress(rs.getString("address"));
		associate.setCity(rs.getString("city"));
	    associate.setState(rs.getString("state"));
	    associate.setZip(rs.getString("zip"));
	    associate.setArrivalDate(rs.getDate("arrivalDate"));
	    associate.setMethodOfTrans(rs.getString("methodOfTrans"));
	    associate.setCarDuringTraining(rs.getString("carDuringTraining"));
    	return associate;
    }
    
    
}