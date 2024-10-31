package com.acorn.di.food;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Food {
	
	String id;
	
	
	public String getFood() {
		return "라면";
	}

}
