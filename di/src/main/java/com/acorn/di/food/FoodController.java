package com.acorn.di.food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Setter;

@Controller
public class FoodController {
	
	
	@Setter(onMethod_ = { @Autowired})
	FoodService service;
	
	
	@GetMapping("/foodInfo")
	public String test() {
		
		String result = service.test1();
		System.out.println( result);
		return  "result";
	}

}
