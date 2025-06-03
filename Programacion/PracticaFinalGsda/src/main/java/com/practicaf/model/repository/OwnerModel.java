package com.practicaf.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicaf.model.DatabaseConnection;
import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.OwnerDto;

public class OwnerModel implements IOwnerModel {
	private Connection connection;

	public OwnerModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}

	@Override
	public boolean addCarOwner(OwnerDto owner) {
		CarResponseDto car = owner.getSharedCar();
		String querySelectCar = "SELECT c.plate FROM Car c INNER JOIN Owner o ON c.plate = o.car_plate INNER JOIN User u ON o.user_name = u.name WHERE c.brand LIKE ? and c.model LIKE ? and c.plate LIKE ? and c.year = ? and u.name = ?";
		String querySelectNewOwner = "SELECT name FROM User WHERE uuid = ?";
		String queryShareCar = "INSERT INTO Owner (car_plate, user_name) VALUES (?, ?)";
		try (PreparedStatement ps1 = connection.prepareStatement(querySelectCar);
				PreparedStatement ps2 = connection.prepareStatement(querySelectNewOwner);
				PreparedStatement ps3 = connection.prepareStatement(queryShareCar);) {

			ps1.setString(1, car.getBrand());
			ps1.setString(2, car.getModel());
			ps1.setString(3, car.getPlate());
			ps1.setInt(4, car.getYear());
			ps1.setString(5, owner.getOwner());

			try (ResultSet rs1 = ps1.executeQuery()) {
				if (rs1.next()) {
					String plateCar = rs1.getString(1);

					ps2.setString(1, owner.getUuid());

					try (ResultSet rs2 = ps2.executeQuery()) {
						if (rs2.next()) {
							String userName = rs2.getString(1);

							ps3.setString(1, plateCar);
							ps3.setString(2, userName);
							ps3.executeUpdate();
						} else {
							System.out.println("Coche no encontrado");
						}
					}
				} else {
					System.out.println("Usuario no encontrado");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCar(CarResponseDto selectedCar, String userName) {
	    String queryDeleteOwner = "DELETE FROM Owner WHERE user_name = ? AND car_plate = ?";

	    try (PreparedStatement ps = connection.prepareStatement(queryDeleteOwner)) {
	        ps.setString(1, userName);
	        ps.setString(2, selectedCar.getPlate());
	        
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}

}
