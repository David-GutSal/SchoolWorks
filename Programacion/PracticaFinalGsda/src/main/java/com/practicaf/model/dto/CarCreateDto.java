package com.practicaf.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarCreateDto {
	private String brand;
	private String model;
	private String plate;
	private int year;
	private String userName;
}
