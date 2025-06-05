package com.practicaf.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.util.List;

import com.practicaf.model.dto.CarCreateDto;
import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.ExpenseDto;
import com.practicaf.model.dto.OwnerDto;
import com.practicaf.model.repository.CarModel;
import com.practicaf.model.repository.ExpenseModel;
import com.practicaf.model.repository.ICarModel;
import com.practicaf.model.repository.IExpenseModel;
import com.practicaf.model.repository.IOwnerModel;
import com.practicaf.model.repository.IUserModel;
import com.practicaf.model.repository.OwnerModel;
import com.practicaf.model.repository.UserModel;

public class MainController implements IMainController {
	private ICarModel carModel;
	private IOwnerModel ownerModel;
	private IUserModel userModel;
	private IExpenseModel expenselModel;

	public MainController() throws ClassNotFoundException, SQLException, IOException {
		this.carModel = new CarModel();
		this.ownerModel = new OwnerModel();
		this.userModel = new UserModel();
		this.expenselModel = new ExpenseModel();
	}

	public boolean carCreateDto(CarCreateDto car) {
		boolean result = this.carModel.carCreateDto(car);
		return result;
	}

	@Override
	public List<CarResponseDto> requestCarList(String userName) {
		return carModel.carList(userName);
	}

	@Override
	public boolean addCarOwner(OwnerDto owner) {
		boolean result = ownerModel.addCarOwner(owner);
		return result;
	}

	@Override
	public boolean deleteCar(CarResponseDto selectedCar, String userName) {
		boolean result = ownerModel.deleteCar(selectedCar, userName);
		return result;
		
	}

	@Override
	public boolean editCar(CarResponseDto editedCar, String oldPlate) {
		boolean result = carModel.carEditDto(editedCar, oldPlate);
		return result;
	}

	@Override
	public String requestUuid(String userName) {
		String uuid = userModel.searchUuid(userName);
		if(uuid != null) {
			return uuid;
		}
			return uuid = "Not Found";
	}

	@Override
	public boolean addExpense(String carPlate, ExpenseDto expense) {
		boolean result = expenselModel.addExpense(carPlate, expense);
		return result;
	}

	@Override
	public List<ExpenseDto> requestExpenses(CarResponseDto selectedCar) {
		List<ExpenseDto> list = expenselModel.requestExpenses(selectedCar);
		return list;
		
	}

}
