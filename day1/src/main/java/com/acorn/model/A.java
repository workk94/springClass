package com.acorn.model;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class A {	
	
	// json데이터로 응답해줌 jackson
	@ResponseBody
	@GetMapping("/json")
	public User2 getData() {
		 User2 user = new User2( );
		user.setId("test");
		user.setPw("1234");
		return user ;
	}

}
