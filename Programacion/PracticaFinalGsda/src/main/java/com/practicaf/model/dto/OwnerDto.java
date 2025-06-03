package com.practicaf.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnerDto {
	private String Owner;
	private String uuid;
	private CarResponseDto sharedCar;
}
