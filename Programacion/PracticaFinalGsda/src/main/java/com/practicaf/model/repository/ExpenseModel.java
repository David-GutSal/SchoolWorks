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
		String queryInsertExpense = "INSERT INTO Expense (car_plate, type, mileage, date, amount, description) VALUES (?, ?, ?, ?, ?, ?)";

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


	public List<ExpenseDto> requestExpenses(CarResponseDto selectedCar, String selectedFilter, String textMin, String textMax) {
		StringBuilder query = new StringBuilder("SELECT type, mileage, date, amount, description FROM Expense WHERE car_plate LIKE ?");
		List<ExpenseDto> expenseList = new ArrayList<>();

		try {

			PreparedStatement ps2 = connection.prepareStatement(query.toString());
			ps2.setString(1, selectedCar.getPlate());


			if ("Fecha".equals(selectedFilter)) {

				query.append(" AND date >= ? AND date <= ?");
				ps2 = connection.prepareStatement(query.toString());
				ps2.setString(1, selectedCar.getPlate());
				ps2.setString(2, textMin); // fecha mínima
				ps2.setString(3, textMax); // fecha máxima
			} else if ("Kilometraje".equals(selectedFilter)) {

				query.append(" AND mileage >= ? AND mileage <= ?");
				ps2 = connection.prepareStatement(query.toString());
				ps2.setString(1, selectedCar.getPlate());
				ps2.setInt(2, textMin.isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(textMin)); // kilometraje mínimo
				ps2.setInt(3, textMax.isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(textMax)); // kilometraje máximo
			}

			// Ejecutar la consulta
			ResultSet rs = ps2.executeQuery();

			while (rs.next()) {
				String type = rs.getString(1);
				int mileage = rs.getInt(2);
				String date = rs.getString(3);
				double amount = rs.getDouble(4);
				String description = rs.getString(5);

				ExpenseDto expense = new ExpenseDto(type, mileage, date, amount, description);
				expenseList.add(expense);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expenseList;
	}

}
