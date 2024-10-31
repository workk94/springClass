package com.acorn.di.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class FoodService {

	@Setter( onMethod_ = @Autowired)
	Food food;
	
	public String test1() {
		return food.getFood();
	}
}
