package com.acorn.day2.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorServiceSpringContainer {
	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext( "com/acorn/day2/di/setting.xml"  );
		
		CalculatorService service =  ac.getBean(CalculatorService.class);
		service.addNumber(5, 3);
	}
}
