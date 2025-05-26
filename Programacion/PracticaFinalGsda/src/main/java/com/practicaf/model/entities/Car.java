package com.practicaf.model.entities;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
	private String brand;
	private String model;
	private String plate;
	private Date year;
	private List<User> users;
}
