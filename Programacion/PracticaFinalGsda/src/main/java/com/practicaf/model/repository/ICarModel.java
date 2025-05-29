package com.practicaf.model.repository;

import java.util.List;

import com.practicaf.model.entities.AddCar;
import com.practicaf.model.entities.Cars;

public interface ICarModel {

	boolean addCar(AddCar car);

	List<Cars> carList(String userName);

}
