package com.practicaf.model.repository;

import com.practicaf.model.dto.CarResponseDto;
import com.practicaf.model.dto.OwnerDto;

public interface IOwnerModel {

	boolean addCarOwner(OwnerDto owner);

	boolean deleteCar(CarResponseDto selectedCar, String userName);

}
