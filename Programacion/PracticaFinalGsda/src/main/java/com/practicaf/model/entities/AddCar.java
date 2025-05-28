package com.practicaf.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCar {
	private String brand;
	private String model;
	private String plate;
	private String year;
	private String userName;
}
