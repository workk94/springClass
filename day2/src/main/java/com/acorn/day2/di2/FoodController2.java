package com.acorn.day2.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController2 {
	
	
	FoodService service;

	//Injection, 생성자주입

	@Autowired
	public FoodController2(FoodService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/menu2")
	public String method() {
		String menu = service.getMenu();
		System.out.println(menu);
		return "result";
	}

}	
