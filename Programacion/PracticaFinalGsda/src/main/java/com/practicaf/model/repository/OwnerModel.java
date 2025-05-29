package com.practicaf.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.practicaf.model.DatabaseConnection;
import com.practicaf.model.dto.NewOwner;

public class OwnerModel implements IOwnerModel {
	private Connection connection;

	public OwnerModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}
	
	@Override
	public boolean addCarOwner(NewOwner owner) {
//		String querySelectCar = "INSERT INTO Car (brand, model, plate, year) VALUES (?, ?, ?, ?)";
//		String queryAddOwnerCar = "INSERT INTO Car (brand, model, plate, year) VALUES (?, ?, ?, ?)";
//		try (PreparedStatement ps1 = connection.prepareStatement(queryInsertCar);){
//			ps1.setString(1, car.getBrand());
//		}catch(SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
		return false;
	}
}
