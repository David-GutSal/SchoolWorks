package com.practicaf.model.repository;

import java.util.List;

import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.ExpenseDto;

public interface IExpenseModel {

	boolean addExpense(String carPlate, ExpenseDto expense);

	List<ExpenseDto> requestExpenses(CarResponseDto selectedCar);

}
