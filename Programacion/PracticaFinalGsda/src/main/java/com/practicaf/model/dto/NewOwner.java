package com.practicaf.model.dto;

import com.practicaf.model.entities.Cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewOwner {
	private String owner;
	private String uuid;
	private Cars newOwner;
}
