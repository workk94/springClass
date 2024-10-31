package com.acorn.day2.di;

public class CalculatorMain {

	public static void main(String[] args) {
		CalculatorService service = new CalculatorService();
		service.addNumber(10, 5);
	}
}
