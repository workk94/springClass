package com.acorn.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelAttribute실습 {
	
	
	@RequestMapping("/mAttTest")
	public String  method1( Customer customer) {		
		System.out.println( customer.getName());
		
		return "mAttrView";
	}

}
