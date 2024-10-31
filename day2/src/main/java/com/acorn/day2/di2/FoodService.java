package com.acorn.day2.di2;

import org.springframework.stereotype.Component;

//스프링 컨테이너에게 객체생성 지시함 

@Component
public class FoodService {

	public String getMenu() {
		return "라면";
	}
}
