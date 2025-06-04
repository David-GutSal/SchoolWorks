package com.practicaf.model.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practicaf.model.DatabaseConnection;
import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.ExpenseDto;

public class ExpenseModel implements IExpenseModel {
	private Connection connection;

	public ExpenseModel() throws ClassNotFoundException, SQLException, IOException {
		this.connection = DatabaseConnection.getConnection();
	}

	@Override
	public boolean addExpense(String carPlate, ExpenseDto expense) {
		String queryInsertExpense = "INSERT INTO Expense (car_plate, type, mileage, date, amount, description) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement ps1 = connection.prepareStatement(queryInsertExpense);) {

			ps1.setString(1, carPlate);
			ps1.setString(2, expense.getExpenseType());
			ps1.setInt(3, expense.getMileage());
			ps1.setString(4, expense.getDate());
			ps1.setDouble(5, expense.getAmount());
			ps1.setString(6, expense.getDescription());
			ps1.executeUpdate();



		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/*@Override
	public void requestExpenses(CarResponseDto selectedCar) {
		String query = "SELECT ";
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
	}*/
}
