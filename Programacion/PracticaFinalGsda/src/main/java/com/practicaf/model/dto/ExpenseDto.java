package com.practicaf.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseDto {
	private String expenseType;
	private int mileage;
	private String date;
	private double amount;
	private String description;
}
