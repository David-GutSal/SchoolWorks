package com.practicaf.controller;

import com.practicaf.model.repository.CarModel;
import com.practicaf.model.repository.ICarModel;
import com.practicaf.model.repository.IUserModel;
import com.practicaf.model.repository.UserModel;

public class MainController implements IMainController{
	private IUserModel userModel;
	private ICarModel carModel;
	
	public MainController() {
		this.userModel = new UserModel();
		this.carModel = new CarModel();
	}
	
	
}
