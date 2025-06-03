package com.practicaf.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarResponseDto {
	private String brand;
	private String model;
	private String plate;
	private int year;
	
	public String toString() {
		return " " + brand + " - " + model + " - " + plate + " - " + year;
	}

}
