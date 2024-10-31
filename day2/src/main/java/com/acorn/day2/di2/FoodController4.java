package com.acorn.day2.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Setter;

@Controller
public class FoodController4 {

	
	@Setter(onMethod_ = @Autowired)
	FoodService service;

	@RequestMapping("/menu4")
	public String method(Model model) {
		
		String food = service.getMenu();
		model.addAttribute("food", food);
		return "result";
	}
}
