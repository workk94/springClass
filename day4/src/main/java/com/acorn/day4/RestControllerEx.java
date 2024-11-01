package com.acorn.day4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//데이터를 응답하는 경우  
// controller 의 모든 매서드가 데이터가 응답하는 경우  RestController을 사용할 수 있다.

@RestController
//@Controller
public class RestControllerEx {

	
	//@ResponseBody
	@RequestMapping("/data10")
	public String  data1() {		
		return  "data";
	}
	
	
	//@ResponseBody
	@RequestMapping("/data11")	
	public User  data2() {		  
		return   new User("test", "1234");
	}
	
	
}
