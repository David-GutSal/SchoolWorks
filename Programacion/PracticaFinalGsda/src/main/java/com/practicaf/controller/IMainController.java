package com.practicaf.controller;

import java.util.List;

import com.practicaf.model.dto.NewOwner;
import com.practicaf.model.entities.AddCar;
import com.practicaf.model.entities.Cars;

public interface IMainController {

	boolean addCar(AddCar car);

	List<Cars> requestCarList(String userName);

	boolean addCarOwner(NewOwner owner);

}
