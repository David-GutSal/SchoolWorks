package com.practicaf.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cars {
	private String brand;
	private String model;
	private String plate;
	private String year;
	
	public String toString() {
		return " " + brand + " - " + model + " - " + plate + " - " + year;
	}
}
