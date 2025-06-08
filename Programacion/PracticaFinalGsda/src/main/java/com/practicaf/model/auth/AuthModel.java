package com.practicaf.model.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.practicaf.model.DatabaseConnection;
import com.practicaf.model.dto.UserLogInDto;
import com.practicaf.model.dto.UserSignInDto;

public class AuthModel implements IAuthModel {
	private Connection connection;

	public AuthModel() throws ClassNotFoundException, SQLException, IOException {

		this.connection = DatabaseConnection.getConnection();
	}

	public boolean register(UserSignInDto signInUser) {
		try {
			String query = "INSERT INTO User (name, password, uuid) value (?, ?, ?)";
			PreparedStatement ps1 = connection.prepareStatement(query);

			ps1.setString(1, signInUser.getName());
			ps1.setString(2, signInUser.getPassword());
			ps1.setString(3, signInUser.getUuid());

			ps1.executeUpdate();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public UserLogInDto byName(String name) {
		String query = "SELECT name, password FROM User WHERE name like ?";

		try {
			PreparedStatement ps2 = connection.prepareStatement(query);

			ps2.setString(1, name);

			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {
				System.out.println("Usuario encontrado");
				String nameDb = rs.getString(1);
				String password = rs.getString(2);

				UserLogInDto user = new UserLogInDto(nameDb, password);
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
}
