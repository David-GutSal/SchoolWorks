package com.practicaf.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicaf.model.DatabaseConnection;
import com.practicaf.model.dto.NewOwner;
import com.practicaf.model.entities.Cars;

public class OwnerModel implements IOwnerModel {
	private Connection connection;

	public OwnerModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}
	
	@Override
	public boolean addCarOwner(NewOwner owner) {
		Cars car = owner.getSharedCar();
		String querySelectCar = "SELECT c.id_car FROM Car c INNER JOIN Owner o ON c.id_car = o.id_car INNER JOIN User u ON o.id_user = u.id_user WHERE c.brand LIKE ? and c.model LIKE ? and c.plate LIKE ? and c.year = ? and u.name = ?";
		String querySelectNewOwner = "SELECT id_user FROM User WHERE uuid = ?";
		String queryShareCar = "INSERT INTO Owner (id_user, id_car) VALUES (?, ?)";
		try (PreparedStatement ps1 = connection.prepareStatement(querySelectCar);
				PreparedStatement ps2 = connection.prepareStatement(querySelectNewOwner);
				PreparedStatement ps3 = connection.prepareStatement(queryShareCar);){
			
			ps1.setString(1, car.getBrand());
			ps1.setString(2, car.getModel());
			ps1.setString(3, car.getPlate());
			ps1.setString(4, car.getYear());
			ps1.setString(5, owner.getOwner());
			
			try(ResultSet rs1 = ps1.executeQuery()){
				if(rs1.next()) {
					int idCar = rs1.getInt(1);
					
					ps2.setString(1, owner.getUuid());
					
					try (ResultSet rs2 = ps2.executeQuery()) {
						if (rs2.next()) {
							int idUser = rs2.getInt(1);
							
							ps3.setInt(1, idUser);
							ps3.setInt(2, idCar);
							ps3.executeUpdate();
						} else {
							System.out.println("Coche no encontrado");
						}
					}
				}else {
					System.out.println("Usuario no encontrado");
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
