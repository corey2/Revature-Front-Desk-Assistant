package com.Dao.java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojos.java.AdminPOJO;
import com.pojos.java.AssociatePOJO;
import com.util.java.Util;

public class AdminDAO extends AssociateDAO {
	//private Connection connection = null;

	public AdminDAO() {
		super();
	}

	public void addAssociate(AssociatePOJO associate) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into associates(username,firstName,lastName,email) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, associate.getUsername());
			preparedStatement.setString(2, associate.getFirstName());
			preparedStatement.setString(3, associate.getLastName());
			preparedStatement.setString(4, associate.getEmail());
			preparedStatement.execute(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAssociate(String username){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from associates where username=?");
            // Parameters start with 1
            preparedStatement.setString(1, username);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public List<AssociatePOJO> getAllAssociates() {
		AssociatePOJO associate = null;
		List<AssociatePOJO> associateList = new ArrayList<AssociatePOJO>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from associates");
			while (rs.next()) {
				associate = buildAssociate(rs);
				associateList.add(associate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return associateList;
	}
	
	public void addAdmin(AdminPOJO admin) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into admins(username,firstName,lastName,email) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, admin.getUsername());
			preparedStatement.setString(2, admin.getFirstName());
			preparedStatement.setString(3, admin.getLastName());
			preparedStatement.setString(4, admin.getEmail());
			preparedStatement.execute(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAdmin(AdminPOJO admin) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update admins set firstname=?, lastname=?, email=?, where username=?");
            preparedStatement.setString(1, admin.getFirstName());
            preparedStatement.setString(2, admin.getLastName());
            preparedStatement.setString(3, admin.getEmail());
            preparedStatement.setString(4, admin.getUsername());         
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void deleteAdmin(String username) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from admins where username=?");
            preparedStatement.setString(1, username);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public AdminPOJO getAdmin(String cName, String cValue) {
    	PreparedStatement preparedStatement = null;
    	AdminPOJO admin = null;
        try {
			preparedStatement = connection.
				prepareStatement("select * from admins where ?=?");
			preparedStatement.setString(1, cName);
			preparedStatement.setString(2, cValue);
			ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	admin = new AdminPOJO();
	        	admin.setUsername(rs.getString("username"));
	        	admin.setFirstName(rs.getString("firstname"));
	        	admin.setLastName(rs.getString("lastname"));
	        	admin.setEmail(rs.getString("email"));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return admin;
    }
	
}