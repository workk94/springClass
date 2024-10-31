package com.acorn.day2.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
	
	

	FoodService service;
	
	@Autowired // 세터 주입 
	public void setService(FoodService service) {
		this.service = service;
	}

	
	@GetMapping("/menu")
	public String menu () {
		
		String menu = service.getMenu();
		System.out.println(menu);
		return "menuview";
	}
}
