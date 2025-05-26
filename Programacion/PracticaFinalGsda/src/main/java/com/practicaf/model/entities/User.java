package com.practicaf.model.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	private String name;
	private String password;
	private String uuid;
	private List<Car> cars;
}
