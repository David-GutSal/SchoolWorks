package com.practicaf.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practicaf.model.DatabaseConnection;
import com.practicaf.model.entities.AddCar;
import com.practicaf.model.entities.Cars;

public class CarModel implements ICarModel {
	private Connection connection;

	public CarModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}

	@Override
	public boolean addCar(AddCar car) {
		String queryInsertCar = "INSERT INTO Car (brand, model, plate, year) VALUES (?, ?, ?, ?)";
		String querySelectUser = "SELECT id_user FROM User WHERE name LIKE ?";
		String queryInsertOwner = "INSERT INTO Owner (id_user, id_car) VALUES (?, ?)";
		String querySelectCar = "SELECT id_car FROM Car WHERE brand LIKE ? OR model LIKE ? OR plate LIKE ? OR year = ?";

		try (PreparedStatement ps1 = connection.prepareStatement(queryInsertCar);
				PreparedStatement ps2 = connection.prepareStatement(querySelectUser);
				PreparedStatement ps3 = connection.prepareStatement(querySelectCar);
				PreparedStatement ps4 = connection.prepareStatement(queryInsertOwner);) {

			ps1.setString(1, car.getBrand());
			ps1.setString(2, car.getModel());
			ps1.setString(3, car.getPlate());
			ps1.setString(4, car.getYear());
			ps1.executeUpdate();

			ps2.setString(1, car.getUserName());
			try (ResultSet rs1 = ps2.executeQuery()) {
				if (rs1.next()) {
					int idUser = rs1.getInt(1);

					ps3.setString(1, car.getBrand());
					ps3.setString(2, car.getModel());
					ps3.setString(3, car.getPlate());
					ps3.setString(4, car.getYear());
					try (ResultSet rs2 = ps3.executeQuery()) {
						if (rs2.next()) {
							int idCar = rs2.getInt(1);

							ps4.setInt(1, idUser);
							ps4.setInt(2, idCar);
							ps4.executeUpdate();
						} else {
							System.out.println("Coche no encontrado");
						}
					}
				} else {
					System.out.println("Usuario no encontrado");
				}
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Cars> carList() {
		String query = "SELECT c.brand AS b, c.model AS m, c.plate AS p, c.year AS y "
				+ "FROM Car c \r\n"
				+ "INNER JOIN Owner o ON c.id_car = o.id_car "
				+ "INNER JOIN User u ON u.id_user = o.id_user "
				+ "WHERE u.name = ?";

		try {
			List<Cars> cars = new ArrayList<>();
			PreparedStatement ps2 = connection.prepareStatement(query);

			ResultSet rs = ps2.executeQuery();

			while (rs.next()) {
				String brand = rs.getString(1);
				String model = rs.getString(2);
				String plate = rs.getString(3);
				String year = rs.getString(4);

				Cars car = new Cars(brand, model, plate, year);
				cars.add(car);
			}
			return cars;
		} catch (Exception e) {
			return null;
		}
	}
}