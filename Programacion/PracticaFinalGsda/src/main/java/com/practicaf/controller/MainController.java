package com.practicaf.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.util.List;

import com.practicaf.model.dto.CarCreateDto;
import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.OwnerDto;
import com.practicaf.model.repository.CarModel;
import com.practicaf.model.repository.ICarModel;
import com.practicaf.model.repository.IOwnerModel;
import com.practicaf.model.repository.OwnerModel;

public class MainController implements IMainController {
	private ICarModel carModel;
	private IOwnerModel ownerModel;

	public MainController() throws ClassNotFoundException, SQLException, IOException {
		this.carModel = new CarModel();
		this.ownerModel = new OwnerModel();
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
		boolean result = this.carModel.carEditDto(editedCar, oldPlate);
		return result;
	}

}
