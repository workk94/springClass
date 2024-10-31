package com.acorn.day1prac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//데이터 응답 
//json 응답 


@Controller
public class SecondController {
	
	
	
	//@ResponseBody : 반환타입의 데이터를 json으로 응답
	@ResponseBody
	@GetMapping("/jsondata")
	public Member method1( ) {
		Member member = new Member();
		
		member.setId("hong");
		member.setPw("1234");
		
		return member;
	}
}
