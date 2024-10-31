package com.acorn.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttributeEx {
	
	 
	@RequestMapping("/mAtt1")
	public String  test1(@ModelAttribute  User user) {    
		//@ModelAttribute   생략가능함  , model 객체에 자동으로 담아줌  , 이때 키이름은 User type명이다 , 첫글자 소문자 
	
		System.out.println( user);
		return "mview";
	}
	
	
	@RequestMapping("/mAtt2")
	public String  test2( User user) {    //@ModelAttribute   생략가능함  , model 객체에 자동으로 담아줌 
	
		System.out.println( user);
		return "mview";
	}	 
 
	@RequestMapping("/mAtt3")
	public String  test3(@ModelAttribute("nUser") User user) {    // 키이름을 원하는 걸로  정할때는 @ModelAttribute 생략불가함   , model 객체에 자동으로 담아줌 
		
		System.out.println( user);
		return "mview3";                              
	}
	 
	 
	
}
