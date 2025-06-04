package com.practicaf.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicaf.model.DatabaseConnection;

public class UserModel implements IUserModel {
	private Connection connection;

	public UserModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}
	
	public String searchUuid(String userName) {
	    String query = "SELECT uuid FROM User WHERE name = ?";
	    String uuid = null;
	    try {
	        PreparedStatement ps2 = connection.prepareStatement(query);
	        ps2.setString(1, userName);
	        ResultSet rs = ps2.executeQuery();
	        
	        if (rs.next()) {
	            uuid = rs.getString(1);
	        }
	        return uuid;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
