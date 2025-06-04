package com.practicaf.model.repository;

import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.ExpenseDto;

public interface IExpenseModel {

	boolean addExpense(String carPlate, ExpenseDto expense);

	void requestExpenses(CarResponseDto selectedCar);

}
