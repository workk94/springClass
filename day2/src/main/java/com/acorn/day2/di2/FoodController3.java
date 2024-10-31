package com.acorn.day2.di2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FoodController3 {
	
	private final FoodService service;
	
	//메뉴정보 제공하기
	//MVC 
	
	@GetMapping("/menu3")
	public String method() {
		String result = service.getMenu();
		System.out.println(result);
		return "result";
	}
}
