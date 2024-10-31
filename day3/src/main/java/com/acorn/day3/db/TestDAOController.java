package com.acorn.day3.db;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestDAOController {

	
	//dao를 직접쓰지 말고 서비스를 통해서 쓰도록 한다 
	
	
	@Autowired
	TestDAO  dao;
	
	@RequestMapping("/dbTest")
	public String test1() {		
		ArrayList<Customer> list  = dao.select();
		System.out.println( list);
		return "db";
	}
}
