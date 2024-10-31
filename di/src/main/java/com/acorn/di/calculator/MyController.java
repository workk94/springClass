package com.acorn.di.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {

	@Autowired
	Program p;	

	
	@GetMapping("/calculate")
	public void add(  Integer su1,  Integer su2) {		
		 p.addNumber(su1, su2);	 
	}
	
}
