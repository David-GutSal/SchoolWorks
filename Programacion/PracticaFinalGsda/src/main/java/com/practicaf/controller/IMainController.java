package com.practicaf.controller;

import java.util.List;

import com.practicaf.model.dto.CarCreateDto;
import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.ExpenseDto;
import com.practicaf.model.dto.OwnerDto;

public interface IMainController {

	boolean carCreateDto(CarCreateDto car);

	List<CarResponseDto> requestCarList(String userName);

	boolean addCarOwner(OwnerDto owner);

	boolean deleteCar(CarResponseDto selectedCar, String userName);

	boolean editCar(CarResponseDto editedCar, String oldPlate);

	String requestUuid(String userName);

	boolean addExpense(String carPlate, ExpenseDto expense);

	void requestExpenses(CarResponseDto selectedCar);

}
