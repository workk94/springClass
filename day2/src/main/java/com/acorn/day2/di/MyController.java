package com.acorn.day2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	//매서드 단위 매핑
	// MVC
	
	@Autowired // 주입 
	CalculatorService service;
	
	@GetMapping("/calservice")
	public String method(Integer su1, Integer su2) { // ?su1=10&cu2=3
		service.addNumber(su1, su2);
		return "result";
	}
}
