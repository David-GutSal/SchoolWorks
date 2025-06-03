package com.practicaf.model.repository;

import java.util.List;

import com.practicaf.model.dto.CarCreateDto;
import com.practicaf.model.dto.CarResponseDto;

public interface ICarModel {

	boolean carCreateDto(CarCreateDto car);

	List<CarResponseDto> carList(String userName);

	boolean carEditDto(CarResponseDto editedCar, String oldPlate);

}
