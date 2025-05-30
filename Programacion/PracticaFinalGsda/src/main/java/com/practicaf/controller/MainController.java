package com.practicaf.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.util.List;

import com.practicaf.model.dto.NewOwner;
import com.practicaf.model.entities.AddCar;
import com.practicaf.model.entities.Cars;
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

	public boolean addCar(AddCar car) {
		boolean result = this.carModel.addCar(car);
		return result;
	}

	@Override
	public List<Cars> requestCarList(String userName) {
		return carModel.carList(userName);
	}

	@Override
	public boolean addCarOwner(NewOwner owner) {
		boolean result = ownerModel.addCarOwner(owner);
		return result;
	}

}
