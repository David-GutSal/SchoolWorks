package com.practicaf.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.practicaf.model.entities.Car;
import com.practicaf.model.repository.CarModel;
import com.practicaf.model.repository.ICarModel;
import com.practicaf.model.repository.IUserModel;
import com.practicaf.model.repository.UserModel;

public class MainController implements IMainController{
	private IUserModel userModel;
	private ICarModel carModel;
	
	public MainController() throws ClassNotFoundException, SQLException, IOException {
		this.userModel = new UserModel();
		this.carModel = new CarModel();
	}
	
	public boolean addCar(Car car) {
		boolean result = this.carModel.addCar(car);
		return result;
	}
	
	
}
