package com.practicaf.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.practicaf.model.DatabaseConnection;
import com.practicaf.model.entities.Car;

public class CarModel implements ICarModel{
	private Connection connection;

	public CarModel() throws ClassNotFoundException, SQLException, IOException {

		this.connection = DatabaseConnection.getConnection();
	}
	@Override
	public boolean addCar(Car car) {
		try {
			
			String queryInsertCar = "INSERT INTO Car (brand, model, plate, year) value (?, ?, ?, ?)";
			PreparedStatement ps1 = connection.prepareStatement(queryInsertCar);

			ps1.setString(1, car.getBrand());
			ps1.setString(2, car.getModel());
			ps1.setString(3, car.getPlate());
			ps1.setString(4, car.getYear());

			ps1.executeUpdate();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
