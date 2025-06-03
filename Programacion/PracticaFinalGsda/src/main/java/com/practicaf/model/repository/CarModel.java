package com.practicaf.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practicaf.model.DatabaseConnection;
import com.practicaf.model.dto.CarCreateDto;
import com.practicaf.model.dto.CarResponseDto;

public class CarModel implements ICarModel {
	private Connection connection;

	public CarModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}

	@Override
	public boolean carCreateDto(CarCreateDto car) {
	    String queryInsertCar = "INSERT INTO Car (brand, model, plate, year) VALUES (?, ?, ?, ?)";
	    String queryInsertOwner = "INSERT INTO Owner (car_plate, user_name) VALUES (?, ?)";

	    try (PreparedStatement ps1 = connection.prepareStatement(queryInsertCar);
	         PreparedStatement ps2 = connection.prepareStatement(queryInsertOwner)) {

	        
	        ps1.setString(1, car.getBrand());
	        ps1.setString(2, car.getModel());
	        ps1.setString(3, car.getPlate());
	        ps1.setInt(4, car.getYear());
	        ps1.executeUpdate();

	        ps2.setString(1, car.getPlate());
	        ps2.setString(2, car.getUserName());
	        ps2.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }

	    return true;
	}

	public List<CarResponseDto> carList(String userName) {
		String query = "SELECT c.brand AS b, c.model AS m, c.plate AS p, c.year AS y " + "FROM Car c "
				+ "INNER JOIN Owner o ON c.plate = o.car_plate " + "INNER JOIN User u ON u.name = o.user_name "
				+ "WHERE u.name = ?";
		List<CarResponseDto> carResponseDto = new ArrayList<>();
		try {
			PreparedStatement ps2 = connection.prepareStatement(query);

			ps2.setString(1, userName);
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				String brand = rs.getString(1);
				String model = rs.getString(2);
				String plate = rs.getString(3);
				int year = rs.getInt(4);
				CarResponseDto car = new CarResponseDto(brand, model, plate, year);
				carResponseDto.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carResponseDto;
	}

	@Override
	public boolean carEditDto(CarResponseDto editedCar, String oldPlate) {
		String queryUpdateCar = "UPDATE Car SET brand = ?, model = ?, plate = ?, year = ? WHERE plate = ?";
		try (PreparedStatement ps1 = connection.prepareStatement(queryUpdateCar);) {

			ps1.setString(1, editedCar.getBrand());
			ps1.setString(2, editedCar.getModel());
			ps1.setString(3, editedCar.getPlate());
			ps1.setInt(4, editedCar.getYear());
			ps1.setString(5, oldPlate);
			ps1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}